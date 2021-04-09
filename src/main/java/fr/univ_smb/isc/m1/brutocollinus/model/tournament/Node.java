package fr.univ_smb.isc.m1.brutocollinus.model.tournament;

import fr.univ_smb.isc.m1.brutocollinus.model.arsenal.Bruto;

public abstract class Node {
    protected Bruto selectedBruto;

    public Bruto selectedBruto() {
        return this.selectedBruto;
    }
}
