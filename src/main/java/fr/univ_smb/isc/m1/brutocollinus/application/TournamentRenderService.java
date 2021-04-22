package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedTournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TournamentRenderService {
    private final RenderedTournamentRepository repository;

    public TournamentRenderService(RenderedTournamentRepository repository) {
        this.repository = repository;
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

    }

    @Transactional
    public RenderedTournament findByTournament(Tournament tournament) {
        return this.repository.findByTournament(tournament).orElse(null);
    }
}
