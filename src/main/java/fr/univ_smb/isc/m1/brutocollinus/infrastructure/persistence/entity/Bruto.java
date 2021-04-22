package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Bruto extends Identifiable {
    private String name;

    @ManyToOne
    private BrutoClass brutoClass;

    @ManyToOne
    private Player owner;

    public Bruto() {
        // JPA
    }

    public Bruto(String name, BrutoClass brutoClass, Player owner) {
        this.name = name;
        this.brutoClass = brutoClass;
        this.owner = owner;
    }

    public String name() {
        return name;
    }

    public Player owner() {
        return owner;
    }

    public BrutoClass brutoClass() {
        return this.brutoClass;
    }
}