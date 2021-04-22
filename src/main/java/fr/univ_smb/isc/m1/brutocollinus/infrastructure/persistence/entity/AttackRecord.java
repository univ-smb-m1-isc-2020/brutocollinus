package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AttackRecord extends Identifiable {
    @ManyToOne
    private ArmedBruto attacker;

    @ManyToOne
    private ArmedBruto defender;

    private int damage;
    private int defenderHp;

    public AttackRecord() {
        // JPA
    }

    public AttackRecord(ArmedBruto attacker, ArmedBruto defender, int damage, int defenderHp) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.defenderHp = defenderHp;
    }

    public ArmedBruto attacker() {
        return this.attacker;
    }

    public ArmedBruto defender() {
        return this.defender;
    }

    public int defenderHp() {
        return this.defenderHp;
    }

    public int damage() {
        return this.damage;
    }
}