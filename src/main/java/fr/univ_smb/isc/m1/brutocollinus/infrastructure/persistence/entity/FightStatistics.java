package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FightStatistics {
    @Id
    @GeneratedValue
    private Long id;

    private int atk;
    private int hp;
    private int ini;

    public FightStatistics() {
        // JPA
    }

    public FightStatistics(int atk, int hp, int ini) {
        this.atk = atk;
        this.hp = hp;
        this.ini = ini;
    }

    public int atk() {
        return this.atk;
    }

    public int hp() {
        return this.hp;
    }

    public int ini() {
        return this.ini;
    }
}