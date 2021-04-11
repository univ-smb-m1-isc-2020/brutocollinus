package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entry extends Node {
    public Entry() {
        // JPA
    }

    public Entry(ArmedBruto bruto) {
        super(bruto);
    }
}
