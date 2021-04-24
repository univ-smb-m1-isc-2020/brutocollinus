package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.hateoas.RepresentationModel;

public class FightStatisticsResponse extends RepresentationModel<FightStatisticsResponse> {
    public final int atk;
    public final int hp;
    public final int ini;

    public FightStatisticsResponse(FightStatisticsVector fightStatisticsVector) {
        this.atk = fightStatisticsVector.atk();
        this.hp = fightStatisticsVector.hp();
        this.ini = fightStatisticsVector.ini();
    }

    public FightStatisticsResponse(FightStatistics fightStatistics) {
        this.atk = fightStatistics.atk();
        this.hp = fightStatistics.hp();
        this.ini = fightStatistics.ini();
    }
}
