package fr.univ_smb.isc.m1.brutocollinus.model.tournament;

import fr.univ_smb.isc.m1.brutocollinus.model.arsenal.ArmedBruto;

public abstract class Node {
    protected ArmedBruto selectedBruto;

    public ArmedBruto selectedBruto() {
        return this.selectedBruto;
    }
}
