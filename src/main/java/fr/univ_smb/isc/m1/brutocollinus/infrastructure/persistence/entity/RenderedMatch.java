package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
public class RenderedMatch {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String content;

    @ManyToOne
    private Match match;

    public RenderedMatch() {
        // JPA
    }

    public RenderedMatch(Match match, String content) {
        this.match = match;
        this.content = content;
    }

    public String content() {
        return this.content;
    }

    public Match match() {
        return this.match;
    }
}
