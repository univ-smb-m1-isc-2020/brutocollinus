package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Identifiable {
    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    public Identifiable() {
        this.uuid = UUID.randomUUID().toString();
        // JPA
    }

    public String uuid() {
        return this.uuid;
    }
}