package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ArmedBruto extends Identifiable {
    @ManyToOne
    private Bruto bruto;

    @ManyToMany
    @JoinTable(name="armedbruto_gained_stuff")
    private Set<Stuff> gainedStuffs;

    @ManyToMany
    @JoinTable(name="armedbruto_equiped_stuff")
    private Set<Stuff> equipedStuffs;

    @ManyToMany
    @JoinTable(name="armedbruto_equiped_boost")
    private Set<Boost> equipedBoosts;

    public ArmedBruto() {
        // JPA
    }

    public ArmedBruto(Bruto bruto, Set<Stuff> equipedStuffs, Set<Boost> equipedBoosts) {
        this.bruto = bruto;
        this.equipedStuffs = equipedStuffs;
        this.gainedStuffs = new HashSet<>(equipedStuffs);
        this.equipedBoosts = equipedBoosts;
    }

    public Bruto bruto() {
        return this.bruto;
    }

    public Set<Stuff> equipedStuffs() {
        return this.equipedStuffs;
    }

    public void setEquippedStuffs(Set<Stuff> equipedStuffs) {
        this.equipedStuffs = equipedStuffs;
    }

    public Set<Boost> equipedBoosts() {
        return this.equipedBoosts;
    }

    public Set<Stuff> gainedStuffs() {
        return this.gainedStuffs;
    }

    public void addGainedStuff(Stuff stuff) {
        this.gainedStuffs.add(stuff);
    }
}