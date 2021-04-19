package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament extends Identifiable {
    public enum State {
        ACTIVE,
        OVER
    };

    public State state;

    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArmedBruto> participants;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

    public int nbTourProcessed;

    public Tournament() {
        // JPA
    }

    public Tournament(String name, List<ArmedBruto> participants, List<Tour> tours) {
        this.name = name;
        this.participants = participants;
        this.tours = tours;
        this.nbTourProcessed = 0;
    }

    public List<Tour> tours() {
        return this.tours;
    }

    public List<ArmedBruto> participants() {
        return this.participants;
    }

    public String name() {
        return this.name;
    }
}
