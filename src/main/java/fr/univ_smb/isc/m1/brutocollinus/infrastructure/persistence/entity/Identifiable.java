package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Identifiable {
    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    protected Identifiable() {
        this.uuid = UUID.randomUUID().toString();
        // JPA
    }

    public String uuid() {
        return this.uuid;
    }
}