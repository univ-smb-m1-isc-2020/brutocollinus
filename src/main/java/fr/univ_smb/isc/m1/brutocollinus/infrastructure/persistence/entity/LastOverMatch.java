package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
public class LastOverMatch {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Match match;

    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private Player participant;

    private boolean hasWon;

    public LastOverMatch() {
        // JPA
    }

    public LastOverMatch(Match match, Tournament tournament, Player player, boolean hasWon) {
        this.match = match;
        this.tournament = tournament;
        this.participant = player;
        this.hasWon = hasWon;
    }

    public Match match() {
        return this.match;
    }

    public boolean hasWon() {
        return this.hasWon;
    }
}
