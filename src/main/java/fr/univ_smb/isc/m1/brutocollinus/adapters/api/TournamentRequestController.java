package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamenRequestCreateForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestCreateResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentRequestService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TournamentRequestController {

    private final TournamentRequestService tournamentService;
    private final PlayerService playerService;

    public TournamentRequestController(TournamentRequestService tournamentService, PlayerService playerService) {
        this.tournamentService = tournamentService;
        this.playerService = playerService;
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

    @PostMapping(value="/api/tournament/accept/{uuid}")
    @ResponseBody
    public TournamentRequestResponse accept(@PathVariable String uuid) {
        TournamentRequest request = this.tournamentService.get(uuid);

        TournamentRequestResponse response = new TournamentRequestResponse(request);
        return response;
    }
}
