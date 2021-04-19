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
import java.util.List;
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
    public TournamentRequestCreateResponse request(@RequestBody @Valid TournamenRequestCreateForm form) {
        Set<Player> guests = form.guests.stream().map((id) -> this.playerService.get(id)).collect(Collectors.toSet());
        TournamentRequest request = this.tournamentService.create(form.name, guests);
        return new TournamentRequestCreateResponse(request);
    }

    @GetMapping(value="/api/tournament/request/{id}")
    @ResponseBody
    public TournamentRequestResponse get(@PathVariable Long id) {
        TournamentRequest request = this.tournamentService.get(id);
        return new TournamentRequestResponse(request);
    }
}
