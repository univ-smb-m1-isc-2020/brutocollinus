package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player extends Identifiable {
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Bruto> brutos;

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
}