package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import org.springframework.hateoas.RepresentationModel;

public class BrutoResponse extends RepresentationModel<BrutoResponse> {
    public final String uuid;
    public final String name;
    public final String owner;
    public final FightStatisticsResponse fightStatistics;

    public BrutoResponse(Bruto bruto) {
        this.uuid = bruto.uuid();
        this.name = bruto.name();
        this.owner = bruto.owner().uuid();
        this.fightStatistics = new FightStatisticsResponse(bruto.brutoClass().fightStatistics());
    }
}
