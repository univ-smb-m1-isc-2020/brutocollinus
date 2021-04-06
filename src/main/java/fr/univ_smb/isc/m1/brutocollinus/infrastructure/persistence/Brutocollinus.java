package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brutocollinus {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int pv;
    private int atk;
    private int def;
    private int ini;

    public Brutocollinus() {
        // JPA
    }

    public Brutocollinus(String name, String email) {
        this.name = name;
        //this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}