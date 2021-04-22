package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedMatchRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.BattleResult;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.MatchRenderer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MatchRenderService {
    private final RenderedMatchRepository repository;
    private final RenderService renderService;

    public MatchRenderService(RenderedMatchRepository repository, RenderService renderService) {
        this.repository = repository;
        this.renderService = renderService;
    }

    public void renderAll(List<Match> matches) {
        for (Match match : matches) {
            this.render(match);
        }
    }

    private void render(Match match) {
        this.repository.deleteByMatch(match);

        MatchRenderer matchRenderer = new MatchRenderer(match);

        try {
            String content = this.renderService.render(matchRenderer);
            System.out.println(content);
            RenderedMatch renderedMatch = new RenderedMatch(match, content);

            this.repository.save(renderedMatch);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public RenderedMatch findByMatch(Match match) {
        return this.repository.findByMatch(match).orElse(null);
    }
}
