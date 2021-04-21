package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RenderedTournament {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String render;

    @ManyToOne
    private Tournament tournament;

    public RenderedTournament() {
        // JPA
    }

    public RenderedTournament(String render) {
        this.render = render;
    }
}
