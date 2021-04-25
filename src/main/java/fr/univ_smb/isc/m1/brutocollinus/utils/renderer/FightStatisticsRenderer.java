package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;

public class FightStatisticsRenderer {
    public final int atk;
    public final int hp;
    public final int ini;

    public FightStatisticsRenderer(FightStatisticsVector fightStatisticsVector) {
        this.atk = fightStatisticsVector.atk();
        this.hp = fightStatisticsVector.hp();
        this.ini = fightStatisticsVector.ini();
    }

    public FightStatisticsRenderer(FightStatistics fightStatistics) {
        this.atk = fightStatistics.atk();
        this.hp = fightStatistics.hp();
        this.ini = fightStatistics.ini();
    }
}
