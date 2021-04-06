package fr.univ_smb.isc.m1.brutocollinus.model;

public class Bruto {
    private Player owner;

    private String name;
    private int hp;
    private int atk;
    private int ini;

    public Bruto(String name, IBrutoClass brutoClass) {
        this.name = name;
        this.hp = brutoClass.hp();
        this.atk = brutoClass.atk();
        this.ini = brutoClass.ini();
    }

    public String name() {
        return this.name;
    }

    public double hp() {
        return this.hp;
    }

    public double atk() {
        return this.atk;
    }

    public double ini() {
        return this.ini;
    }
}
