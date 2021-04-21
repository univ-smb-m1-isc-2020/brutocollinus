package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;

import java.util.List;

public class BattleResult {
    private ArmedBruto winner;
    private List<AttackRecord> attackRecords;

    public BattleResult(ArmedBruto winner, List<AttackRecord> attackRecords) {
        this.winner = winner;
        this.attackRecords = attackRecords;
    }

    public List<AttackRecord> attackRecords() {
        return this.attackRecords;
    }

    public ArmedBruto winner() {
        return this.winner;
    }
}
