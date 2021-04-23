package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedTournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TournamentRenderService {
    private static final Logger log = LoggerFactory.getLogger(TournamentRenderService.class);
    private final RenderedTournamentRepository repository;
    private final RenderService renderService;

    public TournamentRenderService(RenderedTournamentRepository repository, RenderService renderService) {
        this.repository = repository;
        this.renderService = renderService;
    }

    public void render(Tournament tournament) {
        this.repository.deleteByTournament(tournament);

        TournamentRenderer tournamentRenderer = new TournamentRenderer(tournament);

        try {
            String content = this.renderService.render(tournamentRenderer);
            log.info(content);
            RenderedTournament renderedTournament = new RenderedTournament(tournament, content);

            this.repository.save(renderedTournament);
        } catch (JsonProcessingException e) {
            log.error("Failed render tournament");
        }
    }

    @Transactional
    public RenderedTournament findByTournament(Tournament tournament) {
        return this.repository.findByTournament(tournament).orElse(null);
    }
}
