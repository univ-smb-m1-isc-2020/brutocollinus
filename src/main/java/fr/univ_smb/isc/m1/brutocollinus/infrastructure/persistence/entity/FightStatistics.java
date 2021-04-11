package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FightStatistics {

    @Id
    @GeneratedValue
    private Long id;

    private int pv;
    private int hp;
    private int ini;

    public FightStatistics() {
        // JPA
    }

    public FightStatistics(int pv, int hp, int ini) {
        this.pv = pv;
        this.hp = hp;
        this.ini = ini;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}