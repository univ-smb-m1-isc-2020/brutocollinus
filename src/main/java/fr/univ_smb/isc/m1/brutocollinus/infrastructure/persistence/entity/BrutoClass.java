package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class BrutoClass extends Identifiable {
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private FightStatistics fightStatistics;

    public BrutoClass() {
        // JPA
    }

    public BrutoClass(String name, FightStatistics fightStatistics) {
        this.name = name;
        this.fightStatistics = fightStatistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FightStatistics fightStatistics() {
        return this.fightStatistics;
    }
}