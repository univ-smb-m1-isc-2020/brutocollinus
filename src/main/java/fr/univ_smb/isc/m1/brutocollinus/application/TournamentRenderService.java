package fr.univ_smb.isc.m1.brutocollinus.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedTournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedTournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.springframework.stereotype.Service;


@Service
public class TournamentRenderService {
    private final RenderedTournamentRepository repository;

    public TournamentRenderService(RenderedTournamentRepository repository) {
        this.repository = repository;
    }

    public void render(Tournament tournament) {
        this.repository.deleteByTournament(tournament);

        TournamentRenderer tournamentRenderer = new TournamentRenderer(tournament);

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        String render = gson.toJson(tournamentRenderer);
        System.out.println(render);

        RenderedTournament renderedTournament = new RenderedTournament(render);
        this.repository.save(renderedTournament);
    }
}
