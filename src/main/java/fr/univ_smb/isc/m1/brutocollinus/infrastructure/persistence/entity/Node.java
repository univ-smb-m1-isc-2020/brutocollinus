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
    private ArmedBruto selectedBruto;

    public Node() {
        // JPA
    }

    public Node(ArmedBruto selectedBruto) {
        this.selectedBruto = selectedBruto;
    }

    public ArmedBruto selectedBruto() {
        return this.selectedBruto;
    }
}
