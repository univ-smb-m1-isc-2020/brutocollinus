package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;

import java.util.List;
import java.util.stream.Collectors;

public class ArmedBrutoRenderer extends ArmedBrutoAbstractRenderer {
    public List<StuffRenderer> equipedStuffs;
    public List<BoostRenderer> equipedBoosts;

    public ArmedBrutoRenderer(ArmedBruto participant) {
        super(participant);

        this.equipedStuffs = participant.equipedStuffs().stream()
                .map(StuffRenderer::new)
                .collect(Collectors.toList());
        this.equipedBoosts = participant.equipedBoosts().stream()
                .map(BoostRenderer::new)
                .collect(Collectors.toList());
    }
}
