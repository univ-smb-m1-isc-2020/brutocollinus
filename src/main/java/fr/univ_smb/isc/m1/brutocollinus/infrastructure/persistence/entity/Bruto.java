package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bruto {

    @Id
    @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public Player owner() {
        return owner;
    }
}