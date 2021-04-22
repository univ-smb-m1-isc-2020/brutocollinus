package fr.univ_smb.isc.m1.brutocollinus.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.ArmedBrutoRepository;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.MatchRepository;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.RenderedMatchRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.BattleResult;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.MatchRenderer;
import fr.univ_smb.isc.m1.brutocollinus.utils.renderer.TournamentRenderer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    public ArmedBrutoService armedBrutoService;
    private MatchRepository repository;

    public MatchService(MatchRepository repository, ArmedBrutoService armedBrutoService) {
        this.repository = repository;
        this.armedBrutoService = armedBrutoService;
    }

    private BattleResult processBattle(ArmedBruto firstOpponent, ArmedBruto secondOpponent) {
        FightStatisticsVector firstOpponentStatistics = this.armedBrutoService.totalStatistics(firstOpponent);
        FightStatisticsVector secondOpponentStatistics = this.armedBrutoService.totalStatistics(secondOpponent);

        Battle battle = new Battle(firstOpponent, firstOpponentStatistics, secondOpponent, secondOpponentStatistics);
        return battle.fight();
    }

    public void process(Match match) {
        ArmedBruto firstOpponent = match.leftChild().selectedBruto();
        ArmedBruto secondOpponent = match.rightChild().selectedBruto();

        BattleResult battleResult = this.processBattle(firstOpponent, secondOpponent);


        match.setSelectedBruto(battleResult.winner());
        match.setAttackRecords(battleResult.attackRecords());
    }

    public void processAll(List<Match> matches) {
        for (Match match : matches) {
            this.process(match);
        }
    }

    public Match get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }
}
