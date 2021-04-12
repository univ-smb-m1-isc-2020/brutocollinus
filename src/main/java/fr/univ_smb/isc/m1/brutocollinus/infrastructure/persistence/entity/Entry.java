package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;

@Entity
public class Entry extends Node {
    public Entry() {
        // JPA
    }

    public Entry(ArmedBruto bruto) {
        super(bruto);
    }
}
