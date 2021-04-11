package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ArmedBruto {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Bruto bruto;

    @OneToMany
    private List<Stuff> stuffs;

    @OneToMany
    private List<Boost> boosts;

    public ArmedBruto() {
        // JPA
    }

    public ArmedBruto(Bruto bruto, List<Stuff> stuffs, List<Boost> boosts) {
        this.bruto = bruto;
        this.stuffs = stuffs;
        this.boosts = boosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bruto bruto() {
        return this.bruto;
    }

    public List<Stuff> stuffs() {
        return this.stuffs;
    }

    public List<Boost> boosts() {
        return this.boosts;
    }
}