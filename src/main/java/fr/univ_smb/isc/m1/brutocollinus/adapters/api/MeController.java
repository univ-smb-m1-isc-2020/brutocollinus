package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.*;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.MeCreateBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
public class MeController {

    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final BrutoClassService brutoClassService;
    private final TournamentService tournamentService;

    public MeController(BrutoService brutoService, PlayerService playerService, BrutoClassService brutoClassService, TournamentService tournamentService) {
        this.brutoService = brutoService;
        this.playerService = playerService;
        this.brutoClassService = brutoClassService;
        this.tournamentService = tournamentService;
    }

    @GetMapping(value="/api/me/{uuid}/bruto/all")
    @ResponseBody
    public List<BrutoResponse> allBruto(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);

        List<BrutoResponse> responses = me.brutos().stream()
                .map(BrutoResponse::new)
                .collect(Collectors.toList());

        return responses;
    }

    @GetMapping(value="/api/me/{uuid}/tournament/allinprogress")
    @ResponseBody
    public List<TournamentResponse> allTournament(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);
        List<Tournament> myActiveTournaments = this.tournamentService.allInProgressByParticipant(me);

        List<TournamentResponse> responses = myActiveTournaments.stream()
                .map(TournamentResponse::new)
                .collect(Collectors.toList());

        return responses;
    }

    @PostMapping(value="/api/player/{uuid}/bruto/create")
    @ResponseBody
    public MeCreateBrutoResponse createBruto(@PathVariable String uuid, @RequestBody @Valid MeCreateBrutoForm form) {
        Player me = this.playerService.get(uuid);
        BrutoClass brutoClass = this.brutoClassService.findByName(form.className);
        Bruto bruto = this.brutoService.create(form.name, brutoClass, me);

        MeCreateBrutoResponse response = new MeCreateBrutoResponse(new BrutoResponse(bruto));
        return response;
    }
}
