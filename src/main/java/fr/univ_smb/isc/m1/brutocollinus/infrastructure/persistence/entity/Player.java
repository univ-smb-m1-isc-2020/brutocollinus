package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Player extends Identifiable {
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Bruto> brutos;

    @ManyToMany
    private List<Stuff> stuffs;

    @ManyToMany
    private List<Boost> boosts;

    public Player() {
        // JPA
    }

    public Player(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.brutos = new ArrayList<>();
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public List<Bruto> brutos() {
        return this.brutos;
    }

    public void addBruto(Bruto bruto) {
        this.brutos.add(bruto);
    }

    public List<Stuff> stuffs() {
        return this.stuffs;
    }

    public List<Boost> boosts() {
        return this.boosts;
    }
}