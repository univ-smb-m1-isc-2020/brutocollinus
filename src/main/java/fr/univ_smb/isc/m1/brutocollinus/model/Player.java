package fr.univ_smb.isc.m1.brutocollinus.model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Bruto> brutos;
    private ArrayList<Stuff> stuffs;

    private String name;

    public Player(String name) {
        this.name = name;
        this.brutos = new ArrayList<Bruto>();
        this.stuffs = new ArrayList<Stuff>();
    }

    public void createBruto(String name, IBrutoClass brutoClass) {
        Bruto bruto = new Bruto(name, brutoClass);
        brutos.add(bruto);
    }

    public ArrayList<Bruto> brutos() {
        return this.brutos;
    }
}
