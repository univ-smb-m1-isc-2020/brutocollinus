package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamenRequestCreateForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestCreateResponse;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentRequestResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentRequestService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


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

        TournamentRequestCreateResponse response = new TournamentRequestCreateResponse();
        Link getLink = linkTo(methodOn(TournamentRequestController.class).get(request.uuid())).withSelfRel();
        response.add(getLink);

        return response;
    }

    @GetMapping(value="/api/tournament/request/{uuid}")
    @ResponseBody
    public TournamentRequestResponse get(@PathVariable String uuid) {
        TournamentRequest request = this.tournamentService.get(uuid);

        TournamentRequestResponse response = new TournamentRequestResponse(request);
        Link acceptLink = linkTo(methodOn(TournamentRequestController.class).accept(uuid)).withRel("accept");
        response.add(acceptLink);

        return response;
    }

    @PostMapping(value="/api/tournament/accept/{uuid}")
    @ResponseBody
    public TournamentRequestResponse accept(@PathVariable String uuid) {
        TournamentRequest request = this.tournamentService.get(uuid);

        TournamentRequestResponse response = new TournamentRequestResponse(request);
        Link getLink = linkTo(methodOn(TournamentRequestController.class).get(uuid)).withSelfRel();
        response.add(getLink);

        return response;
    }
}
