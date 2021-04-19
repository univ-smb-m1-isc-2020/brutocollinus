package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.TournamenCreateForm;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.response.TournamentCreateResponse;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value="/api/tournament/request")
    @ResponseBody
    public TournamentCreateResponse request(@RequestBody @Valid TournamenCreateForm form) {
        //for ()
        //Tournament tournament = this.tournamentService.create();
        //return new PlayerResponse(player);
        return new TournamentCreateResponse();
    }

}
