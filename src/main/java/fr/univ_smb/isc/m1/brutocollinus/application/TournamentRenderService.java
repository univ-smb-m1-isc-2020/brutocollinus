package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedTournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentRenderService {
    private final RenderedTournamentRepository repository;
    private final MatchRenderService matchRenderService;

    public TournamentRenderService(RenderedTournamentRepository repository, MatchRenderService matchRenderService) {
        this.repository = repository;
        this.matchRenderService = matchRenderService;
    }

    public void render(Tournament tournament) {
        this.repository.deleteByTournament(tournament);

        TournamentRenderer tournamentRenderer = new TournamentRenderer(tournament);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String content = objectMapper.writeValueAsString(tournamentRenderer);
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
