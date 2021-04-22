package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Tournament extends Identifiable {
    public enum State {
        ACTIVE,
        OVER
    };

    private State state;

    private String name;

    @ManyToMany
    @JoinTable(name = "tournament_armedbruto")
    private Set<ArmedBruto> participants;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Match> matches;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Entry> entries;

    public int nbTourProcessed;

    public Tournament() {
        // JPA
    }

    public Tournament(String name, Set<ArmedBruto> participants, List<Tour> tours, List<Match> matches, List<Entry> entries) {
        this.state = State.ACTIVE;
        this.name = name;
        this.participants = participants;
        this.tours = tours;
        this.matches = matches;
        this.entries = entries;
        this.nbTourProcessed = 0;
    }

    public List<Tour> tours() {
        return this.tours;
    }
    public List<Match> matches() {
        return this.matches;
    }

    public Set<ArmedBruto> participants() {
        return this.participants;
    }

    public String name() {
        return this.name;
    }

    public void setState(State state) {
        this.state = state;
    }
}
