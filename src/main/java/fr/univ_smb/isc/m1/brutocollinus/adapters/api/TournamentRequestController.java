package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamenRequestCreateForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamentRequestAcceptForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestAcceptResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TournamentRequestController {

    private final TournamentRequestService tournamentService;
    private final PlayerService playerService;
    private final BrutoService brutoService;
    private final ArmedBrutoService armedBrutoService;
    private final BoostService boostService;

    public TournamentRequestController(TournamentRequestService tournamentService, PlayerService playerService,
                                       BrutoService brutoService, ArmedBrutoService armedBrutoService,
                                       BoostService boostService) {
        this.tournamentService = tournamentService;
        this.playerService = playerService;
        this.brutoService = brutoService;
        this.armedBrutoService = armedBrutoService;
        this.boostService = boostService;
    }

    @PostMapping(value="/api/tournament/request/create")
    @ResponseBody
    public TournamentRequestResponse create(@RequestBody @Valid TournamenRequestCreateForm form) {
        Set<Player> guests = form.guests.stream().map(this.playerService::get).collect(Collectors.toSet());
        TournamentRequest request = this.tournamentService.create(form.name, guests);

        return new TournamentRequestResponse(request);
    }

    @GetMapping(value="/api/tournament/request/{uuid}")
    @ResponseBody
    public TournamentRequestResponse get(@PathVariable String uuid) {
        TournamentRequest request = this.tournamentService.get(uuid);

        return new TournamentRequestResponse(request);
    }

    @PostMapping(value="/api/tournament/request/accept/{uuid}")
    @ResponseBody
    public TournamentRequestAcceptResponse accept(@PathVariable String uuid, @RequestBody @Valid TournamentRequestAcceptForm form) {
        TournamentRequest request = this.tournamentService.get(uuid);

        Bruto bruto = this.brutoService.get(form.selectedBruto);
        Set<Boost> boosts = new HashSet<>(this.boostService.findAllByUuid(form.selectedBoosts));

        ArmedBruto armedBruto = this.armedBrutoService.create(bruto, boosts);
        this.tournamentService.accept(request, bruto.owner(), armedBruto);

        return new TournamentRequestAcceptResponse(request, armedBruto);
    }
}
