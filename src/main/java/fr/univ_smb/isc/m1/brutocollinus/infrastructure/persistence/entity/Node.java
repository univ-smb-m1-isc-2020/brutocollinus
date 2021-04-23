package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Node extends Identifiable {
    @ManyToOne
    protected ArmedBruto selectedBruto;

    protected Node() {
        // JPA
    }

    protected Node(ArmedBruto selectedBruto) {
        this.selectedBruto = selectedBruto;
    }

    public ArmedBruto selectedBruto() {
        return this.selectedBruto;
    }
}
