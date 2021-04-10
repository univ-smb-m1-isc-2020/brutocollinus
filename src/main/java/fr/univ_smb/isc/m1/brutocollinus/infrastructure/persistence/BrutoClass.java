package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BrutoClass {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private FightStatistics fightStatistics;

    public BrutoClass() {
        // JPA
    }

    public BrutoClass(String name, FightStatistics fightStatistics) {
        this.name = name;
        this.fightStatistics = fightStatistics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}