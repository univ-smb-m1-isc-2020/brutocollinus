package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.MatchRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.BattleResult;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private ArmedBrutoService armedBrutoService;
    private MatchRepository repository;

    public MatchService(MatchRepository repository, ArmedBrutoService armedBrutoService) {
        this.repository = repository;
        this.armedBrutoService = armedBrutoService;
    }

    private BattleResult processBattle(ArmedBruto firstOpponent, ArmedBruto secondOpponent) {
        FightStatisticsVector firstOpponentStatistics = this.armedBrutoService.totalFightStatistics(firstOpponent);
        FightStatisticsVector secondOpponentStatistics = this.armedBrutoService.totalFightStatistics(secondOpponent);

        Battle battle = new Battle(firstOpponent, firstOpponentStatistics, secondOpponent, secondOpponentStatistics);
        return battle.fight();
    }

    private void process(Match match) {
        ArmedBruto firstOpponent = match.leftChild().selectedBruto();
        ArmedBruto secondOpponent = match.rightChild().selectedBruto();

        BattleResult battleResult = this.processBattle(firstOpponent, secondOpponent);

        this.armedBrutoService.gainOneStuffFromOther(battleResult.winner(), battleResult.looser());
        battleResult.copyToMatch(match);
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
