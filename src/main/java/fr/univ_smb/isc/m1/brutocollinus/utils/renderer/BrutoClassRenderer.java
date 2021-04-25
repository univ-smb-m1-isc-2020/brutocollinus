package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;

public class BrutoClassRenderer {
    public String name;
    public FightStatisticsRenderer fightStatistics;

    public BrutoClassRenderer(BrutoClass brutoClass) {
        this.name = brutoClass.name();
        this.fightStatistics = new FightStatisticsRenderer(brutoClass.fightStatistics());
    }
}
