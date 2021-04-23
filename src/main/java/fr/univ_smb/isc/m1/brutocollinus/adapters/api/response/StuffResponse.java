package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import org.springframework.hateoas.RepresentationModel;

public class StuffResponse extends RepresentationModel<StuffResponse> {
    public final String uuid;
    public final String name;
    public final FightStatisticsResponse fightStatistics;

    public StuffResponse(Stuff stuff) {
        this.uuid = stuff.uuid();
        this.name = stuff.name();
        this.fightStatistics = new FightStatisticsResponse(stuff.fightStatistics());
    }
}
