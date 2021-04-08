package fr.univ_smb.isc.m1.brutocollinus.model;

public class Battle {
    private Bruto firstOpponent;
    private Bruto secondOpponent;

    public Battle(Bruto firstOpponent, Bruto secondOpponent) {
        this.firstOpponent = firstOpponent;
        this.secondOpponent = secondOpponent;
    }

    public Bruto fight() {
        return this.firstOpponent;
    }
}
