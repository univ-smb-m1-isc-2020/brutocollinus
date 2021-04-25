package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player extends Nameable {
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Bruto> brutos;

    public Player() {
        // JPA
    }

    public Player(String name, String email, String password) {
        super(name);
        this.email = email;
        this.password = password;
        this.brutos = new ArrayList<>();
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