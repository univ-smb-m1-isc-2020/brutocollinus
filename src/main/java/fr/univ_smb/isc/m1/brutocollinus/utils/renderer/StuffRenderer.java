package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;

public class StuffRenderer {
    public String name;
    public FightStatisticsRenderer fightStatistics;

    public StuffRenderer(Stuff stuff) {
        this.name = stuff.name();
        this.fightStatistics = new FightStatisticsRenderer(stuff.fightStatistics());
    }
}
