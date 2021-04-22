package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;

public class AttackRecordRenderer {
    public ArmedBrutoAbstractRenderer attacker;
    public ArmedBrutoAbstractRenderer defender;
    public int damage;
    public int defenderHp;

    public AttackRecordRenderer(AttackRecord attackRecord) {
        this.attacker = new ArmedBrutoAbstractRenderer(attackRecord.attacker());
        this.defender = new ArmedBrutoAbstractRenderer(attackRecord.defender());
        this.damage = attackRecord.damage();
        this.defenderHp = attackRecord.defenderHp();
    }
}
