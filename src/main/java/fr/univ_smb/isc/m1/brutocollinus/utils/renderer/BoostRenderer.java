package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;

public class BoostRenderer {
    public String name;
    public FightStatisticsRenderer fightStatistics;

    public BoostRenderer(Boost boost) {
        this.name = boost.name();
        this.fightStatistics = new FightStatisticsRenderer(boost.fightStatistics());
    }
}
