package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tour {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Node> nodes;

    public Tour() {
        // JPA
    }

    public Long getId() {
        return id;
    }

    public Tour(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> nodes() {
        return this.nodes;
    }
}
