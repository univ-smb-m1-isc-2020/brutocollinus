package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;

public class StuffResponse extends NameableResponse {
    public final FightStatisticsResponse fightStatistics;

    public StuffResponse(Stuff stuff) {
        super(stuff);
        this.fightStatistics = new FightStatisticsResponse(stuff.fightStatistics());
    }
}
