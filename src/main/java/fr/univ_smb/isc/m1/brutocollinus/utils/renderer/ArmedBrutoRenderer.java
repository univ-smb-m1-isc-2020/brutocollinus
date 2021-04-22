package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;

import java.util.List;
import java.util.stream.Collectors;

public class ArmedBrutoRenderer extends ArmedBrutoAbstractRenderer {
    public List<StuffRenderer> stuffs;
    public List<BoostRenderer> boosts;

    public ArmedBrutoRenderer(ArmedBruto participant) {
        super(participant);

        this.stuffs = participant.stuffs().stream()
                .map(StuffRenderer::new)
                .collect(Collectors.toList());
        this.boosts = participant.boosts().stream()
                .map(BoostRenderer::new)
                .collect(Collectors.toList());
    }
}
