package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Stuff extends Identifiable {
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private FightStatistics fightStatistics;

    public Stuff() {
        // JPA
    }

    public Stuff(String name, FightStatistics fightStatistics) {
        this.name = name;
        this.fightStatistics = fightStatistics;
    }

    public String name() {
        return name;
    }

    public FightStatistics fightStatistics() {
        return this.fightStatistics;
    }
}