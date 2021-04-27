package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;

public class BrutoClassResponse extends NameableResponse {
    public final FightStatisticsResponse fightStatistics;

    public BrutoClassResponse(BrutoClass brutoClass) {
        super(brutoClass);
        this.fightStatistics = new FightStatisticsResponse(brutoClass.fightStatistics());
    }
}
