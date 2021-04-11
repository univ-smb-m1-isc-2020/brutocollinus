package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Bruto> brutos;

    public Player() {
        // JPA
    }

    public Player(String name, String email) {
        this.name = name;
        this.email = email;
        this.brutos = new ArrayList<>();
    }

    public Long getId() {
        return id;
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