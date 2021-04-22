package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedTournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TournamentRenderService {
    private final RenderedTournamentRepository repository;
    private final MatchRenderService matchRenderService;
    private final RenderService renderService;

    public TournamentRenderService(RenderedTournamentRepository repository, MatchRenderService matchRenderService, RenderService renderService) {
        this.repository = repository;
        this.matchRenderService = matchRenderService;
        this.renderService = renderService;
    }

    public void render(Tournament tournament) {
        this.repository.deleteByTournament(tournament);

        TournamentRenderer tournamentRenderer = new TournamentRenderer(tournament);

        try {
            String content = this.renderService.render(tournamentRenderer);
            System.out.println(content);
            RenderedTournament renderedTournament = new RenderedTournament(tournament, content);

            this.repository.save(renderedTournament);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        this.matchRenderService.renderAll(tournament.matches());
    }

    @Transactional
    public RenderedTournament findByTournament(Tournament tournament) {
        return this.repository.findByTournament(tournament).orElse(null);
    }
}
