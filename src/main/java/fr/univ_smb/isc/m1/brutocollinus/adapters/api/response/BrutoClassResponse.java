package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import org.springframework.hateoas.RepresentationModel;

public class BrutoClassResponse extends NameableResponse {
    public final FightStatisticsResponse fightStatistics;

    public BrutoClassResponse(BrutoClass brutoClass) {
        super(brutoClass);
        this.fightStatistics = new FightStatisticsResponse(brutoClass.fightStatistics());
    }
}
