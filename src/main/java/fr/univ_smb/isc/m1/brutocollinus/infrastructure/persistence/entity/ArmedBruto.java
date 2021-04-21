package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ArmedBruto extends Identifiable {
    @ManyToOne
    private Bruto bruto;

    @ManyToMany
    @JoinTable(name="armedbruto_stuff")
    private List<Stuff> stuffs;

    @ManyToMany
    @JoinTable(name="armedbruto_boost")
    private List<Boost> boosts;

    public ArmedBruto() {
        // JPA
    }

    public ArmedBruto(Bruto bruto, List<Stuff> stuffs, List<Boost> boosts) {
        this.bruto = bruto;
        this.stuffs = stuffs;
        this.boosts = boosts;
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