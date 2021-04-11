package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArmedBruto {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Bruto bruto;

    public ArmedBruto() {
        // JPA
    }

    public ArmedBruto(Bruto bruto) {
        this.bruto = bruto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}