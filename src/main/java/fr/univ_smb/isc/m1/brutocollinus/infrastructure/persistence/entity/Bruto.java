package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Bruto extends Nameable {
    @ManyToOne
    private BrutoClass brutoClass;

    @ManyToOne
    private Player owner;

    public Bruto() {
        // JPA
    }

    public Bruto(String name, BrutoClass brutoClass, Player owner) {
        super(name);
        this.brutoClass = brutoClass;
        this.owner = owner;
    }

    public Player owner() {
        return owner;
    }

    public BrutoClass brutoClass() {
        return this.brutoClass;
    }
}