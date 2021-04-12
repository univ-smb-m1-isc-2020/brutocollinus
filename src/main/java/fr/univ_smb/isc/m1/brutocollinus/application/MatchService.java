package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatistics;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    public ArmedBrutoService armedBrutoService;

    public MatchService(ArmedBrutoService armedBrutoService) {
        this.armedBrutoService = armedBrutoService;
    }

    private ArmedBruto processBattle(ArmedBruto firstOpponent, ArmedBruto secondOpponent) {
        FightStatistics firstOpponentStatistics = this.armedBrutoService.totalStatistics(firstOpponent);
        FightStatistics secondOpponentStatistics = this.armedBrutoService.totalStatistics(secondOpponent);

        Battle battle = new Battle(firstOpponent, firstOpponentStatistics, secondOpponent, secondOpponentStatistics);
        return battle.fight();
    }

    public void process(Match match) {
        ArmedBruto firstOpponent = match.leftChild().selectedBruto();
        ArmedBruto secondOpponent = match.rightChild().selectedBruto();

        ArmedBruto selectedBruto = this.processBattle(firstOpponent, secondOpponent);

        match.setSelectedBruto(selectedBruto);
    }
}
