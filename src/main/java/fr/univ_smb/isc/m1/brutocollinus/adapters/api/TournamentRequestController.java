package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamenRequestCreateForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamentRequestAcceptForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestCreateResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TournamentRequestController {

    private final TournamentRequestService tournamentService;
    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final StuffService stuffService;
    private final ArmedBrutoService armedBrutoService;
    private final BoostService boostService;

    public TournamentRequestController(TournamentRequestService tournamentService, PlayerService playerService,
                                       BrutoService brutoService, StuffService stuffService, ArmedBrutoService armedBrutoService,
                                       BoostService boostService) {
        this.tournamentService = tournamentService;
        this.playerService = playerService;
        this.brutoService = brutoService;
        this.stuffService = stuffService;
        this.armedBrutoService = armedBrutoService;
        this.boostService = boostService;
    }

    @PostMapping(value="/api/tournament/request/create")
    @ResponseBody
    public TournamentRequestCreateResponse create(@RequestBody @Valid TournamenRequestCreateForm form) {
        Set<Player> guests = form.guests.stream().map((uuid) -> this.playerService.get(uuid)).collect(Collectors.toSet());
        TournamentRequest request = this.tournamentService.create(form.name, guests);

        TournamentRequestCreateResponse response = new TournamentRequestCreateResponse(request);
        return response;
    }

    @GetMapping(value="/api/tournament/request/{uuid}")
    @ResponseBody
    public TournamentRequestResponse get(@PathVariable String uuid) {
        TournamentRequest request = this.tournamentService.get(uuid);

        TournamentRequestResponse response = new TournamentRequestResponse(request);
        return response;
    }

    @PostMapping(value="/api/tournament/request/accept/{uuid}")
    @ResponseBody
    public TournamentRequestResponse accept(@PathVariable String uuid, @RequestBody @Valid TournamentRequestAcceptForm form) {
        TournamentRequest request = this.tournamentService.get(uuid);

        Bruto bruto = this.brutoService.get(form.selectedBruto);
        List<Stuff> stuffs = this.stuffService.findAllByUuid(form.selectedStuffs);
        List<Boost> boosts = this.boostService.findAllByUuid(form.selectedBoosts);

        ArmedBruto armedBruto = this.armedBrutoService.create(bruto, stuffs, boosts);
        this.tournamentService.accept(request, bruto.owner(), armedBruto);

        TournamentRequestResponse response = new TournamentRequestResponse(request);
        return response;
    }
}
