package fr.univ_smb.isc.m1.brutocollinus.model.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.ArmedBruto;

public class Battle {
    private ArmedBruto firstOpponent;
    private ArmedBruto secondOpponent;

    public Battle(ArmedBruto firstOpponent, ArmedBruto secondOpponent) {
        this.firstOpponent = firstOpponent;
        this.secondOpponent = secondOpponent;
    }

    public ArmedBruto fight() {
        return this.firstOpponent;
    }
}
