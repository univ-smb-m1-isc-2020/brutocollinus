package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
public class RenderedTournament {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String content;

    @ManyToOne
    private Tournament tournament;

    public RenderedTournament() {
        // JPA
    }

    public RenderedTournament(Tournament tournament, String content) {
        this.tournament = tournament;
        this.content = content;
    }

    public String content() {
        return this.content;
    }
}
