package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Boost extends Nameable {
    @OneToOne(cascade = CascadeType.ALL)
    private FightStatistics fightStatistics;

    public Boost() {
        // JPA
    }

    public Boost(String name, FightStatistics fightStatistics) {
        super(name);
        this.fightStatistics = fightStatistics;
    }

    public FightStatistics fightStatistics() {
        return this.fightStatistics;
    }
}