package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;

public class BoostResponse extends NameableResponse {
    public final FightStatisticsResponse fightStatistics;

    public BoostResponse(Boost boost) {
        super(boost);
        this.fightStatistics = new FightStatisticsResponse(boost.fightStatistics());
    }
}
