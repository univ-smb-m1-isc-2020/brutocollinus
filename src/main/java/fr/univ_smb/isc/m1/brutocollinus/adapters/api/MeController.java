package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.MeCreateBrutoForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.BrutoResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.MeLastOverMatchResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class MeController {

    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final BrutoClassService brutoClassService;
    private final TournamentService tournamentService;
    private final LastOverMatchService lastOverMatchService;

    public MeController(BrutoService brutoService, PlayerService playerService, BrutoClassService brutoClassService,
                        TournamentService tournamentService, LastOverMatchService lastOverMatchService) {
        this.brutoService = brutoService;
        this.playerService = playerService;
        this.brutoClassService = brutoClassService;
        this.tournamentService = tournamentService;
        this.lastOverMatchService = lastOverMatchService;
    }

    @GetMapping(value="/api/me/{uuid}/bruto/all")
    @ResponseBody
    public List<BrutoResponse> allBruto(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);

        return me.brutos().stream()
                .map(BrutoResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value="/api/me/{uuid}/tournament/allinprogress")
    @ResponseBody
    public List<TournamentResponse> allTournamentInProgress(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);
        List<Tournament> myActiveTournaments = this.tournamentService.allInProgressByParticipant(me);

        return myActiveTournaments.stream()
                .map(TournamentResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value="/api/me/{uuid}/match/alllast")
    @ResponseBody
    public List<MeLastOverMatchResponse> allLastOverMatch(@PathVariable String uuid) {
        Player me = this.playerService.get(uuid);
        return this.lastOverMatchService.findAllByParticipant(me).stream()
                .map(MeLastOverMatchResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping(value="/api/player/{uuid}/bruto/create")
    @ResponseBody
    public BrutoResponse createBruto(@PathVariable String uuid, @RequestBody @Valid MeCreateBrutoForm form) {
        Player me = this.playerService.get(uuid);
        BrutoClass brutoClass = this.brutoClassService.get(form.brutoClass);
        Bruto bruto = this.brutoService.create(form.name, brutoClass, me);

        return new BrutoResponse(bruto);
    }
}
