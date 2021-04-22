package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.application.TournamentRenderService;
import fr.univ_smb.isc.m1.brutocollinus.application.TournamentService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TournamentController {
    private final TournamentService tournamentService;
    private final TournamentRenderService tournamentRenderService;

    public TournamentController(TournamentRenderService tournamentRenderService, TournamentService tournamentService) {
        this.tournamentService = tournamentService;
        this.tournamentRenderService = tournamentRenderService;
    }

    @GetMapping(value="/api/tournament/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(@PathVariable String uuid) {
        Tournament tournament = this.tournamentService.get(uuid);
        RenderedTournament renderedTournament = this.tournamentRenderService.findByTournament(tournament);

        return ResponseEntity.ok(renderedTournament.content());
    }
}
