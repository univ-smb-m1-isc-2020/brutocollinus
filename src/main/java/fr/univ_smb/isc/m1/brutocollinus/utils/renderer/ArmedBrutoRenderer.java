package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;

public class ArmedBrutoRenderer {
    public String name;

    public ArmedBrutoRenderer(ArmedBruto participant) {
        Bruto bruto = participant.bruto();

        this.name = bruto.name();
    }
}
