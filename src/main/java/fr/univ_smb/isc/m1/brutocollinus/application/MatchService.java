package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.BattleResult;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    public ArmedBrutoService armedBrutoService;

    public MatchService(ArmedBrutoService armedBrutoService) {
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
}
