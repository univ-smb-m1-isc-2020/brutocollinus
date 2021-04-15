package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Node {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    protected ArmedBruto selectedBruto;

    public Node() {
        // JPA
    }

    public Node(ArmedBruto selectedBruto) {
        this.selectedBruto = selectedBruto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArmedBruto selectedBruto() {
        return this.selectedBruto;
    }
}
