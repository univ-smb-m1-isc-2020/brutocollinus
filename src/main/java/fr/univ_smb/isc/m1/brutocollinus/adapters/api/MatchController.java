package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.application.MatchRenderService;
import fr.univ_smb.isc.m1.brutocollinus.application.MatchService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedMatch;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    private final MatchService matchService;
    private final MatchRenderService matchRenderService;

    public MatchController(MatchService matchService, MatchRenderService matchRenderService) {
        this.matchService = matchService;
        this.matchRenderService = matchRenderService;
    }

    @GetMapping(value="/api/match/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(@PathVariable String uuid) {
        Match match = this.matchService.get(uuid);
        RenderedMatch renderedMatch = this.matchRenderService.findByMatch(match);

        return ResponseEntity.ok(renderedMatch.content());
    }
}
