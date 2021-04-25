package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

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