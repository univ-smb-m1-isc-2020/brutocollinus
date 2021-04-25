package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import org.springframework.hateoas.RepresentationModel;

public class BrutoClassResponse extends RepresentationModel<BrutoClassResponse> {
    public final String uuid;
    public final String name;
    public final FightStatisticsResponse fightStatistics;

    public BrutoClassResponse(BrutoClass brutoClass) {
        this.uuid = brutoClass.uuid();
        this.name = brutoClass.name();
        this.fightStatistics = new FightStatisticsResponse(brutoClass.fightStatistics());
    }
}
