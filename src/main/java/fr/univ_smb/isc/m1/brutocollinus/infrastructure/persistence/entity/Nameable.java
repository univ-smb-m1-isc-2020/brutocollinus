package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;

@Entity
public class Nameable extends Identifiable {
    private String name;

    protected Nameable() {
        // JPA
    }

    protected Nameable(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}