package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;
import org.springframework.hateoas.RepresentationModel;

public class BoostResponse extends RepresentationModel<BoostResponse> {
    public final String uuid;
    public final String name;
    public final FightStatisticsResponse fightStatistics;

    public BoostResponse(Boost boost) {
        this.uuid = boost.uuid();
        this.name = boost.name();
        this.fightStatistics = new FightStatisticsResponse(boost.fightStatistics());
    }
}
