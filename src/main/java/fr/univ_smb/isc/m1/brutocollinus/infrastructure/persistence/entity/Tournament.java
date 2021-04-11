package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue
    private Long id;

    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArmedBruto> participants;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

    public Tournament() {
        // JPA
    }

    public Tournament(List<ArmedBruto> participants, List<Tour> tours) {
        this.participants = participants;
        this.tours = tours;
    }

    public List<Tour> tours() {
        return this.tours;
    }

    public List<ArmedBruto> participants() {
        return this.participants;
    }
}
