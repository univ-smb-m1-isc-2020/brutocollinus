package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;

public class RenderedArmedBruto {
    private String name;
    private Long id;

    public RenderedArmedBruto(ArmedBruto participant) {
        Bruto bruto = participant.bruto();

        this.id = participant.getId();
        this.name = bruto.name();
    }
}
