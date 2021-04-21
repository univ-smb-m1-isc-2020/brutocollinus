package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;

public class AttackRecordRenderer {
    public String attacker;
    public String defender;
    public int damage;
    public int defenderHp;

    public AttackRecordRenderer(AttackRecord record) {
        this.attacker = record.attacker().uuid();
        this.defender = record.defender().uuid();
        this.damage = record.damage();
        this.defenderHp = record.defenderHp();
    }
}
