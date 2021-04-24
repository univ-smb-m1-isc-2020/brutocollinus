package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;

import java.util.List;
import java.util.stream.Collectors;

public class ArmedBrutoRenderer extends ArmedBrutoAbstractRenderer {
    public List<StuffRenderer> equipedStuffs;
    public List<BoostRenderer> equipedBoosts;
    public FightStatisticsRenderer totalFightStatistics;

    public ArmedBrutoRenderer(ArmedBruto participant) {
        super(participant);

        this.equipedStuffs = participant.equipedStuffs().stream()
                .map(StuffRenderer::new)
                .collect(Collectors.toList());
        this.equipedBoosts = participant.equipedBoosts().stream()
                .map(BoostRenderer::new)
                .collect(Collectors.toList());

        FightStatisticsVector totalFightStatistics = ArmedBrutoService.totalStatistics(participant);
        this.totalFightStatistics = new FightStatisticsRenderer(totalFightStatistics);
    }
}
