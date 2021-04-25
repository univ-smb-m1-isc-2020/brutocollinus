package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;

import java.util.List;

public class BattleResult {
    private ArmedBruto winner;
    private ArmedBruto looser;
    private List<AttackRecord> attackRecords;

    public BattleResult(ArmedBruto winner, ArmedBruto looser, List<AttackRecord> attackRecords) {
        this.winner = winner;
        this.looser = looser;
        this.attackRecords = attackRecords;
    }

    public List<AttackRecord> attackRecords() {
        return this.attackRecords;
    }

    public ArmedBruto winner() {
        return this.winner;
    }

    public ArmedBruto looser() {
        return this.looser;
    }

    public void copyToMatch(Match match) {
        match.setWinnerAndLooser(this.winner, this.looser);
        match.setAttackRecords(this.attackRecords);
    }
}
