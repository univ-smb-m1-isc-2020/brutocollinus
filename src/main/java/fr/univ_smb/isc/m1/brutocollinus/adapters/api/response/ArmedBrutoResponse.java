package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;

import java.util.List;
import java.util.stream.Collectors;

public class ArmedBrutoResponse extends IdentifiableResponse {
    public final String bruto;
    public final List<StuffResponse> equipedStuffs;
    public final List<StuffResponse> gainedStuffs;
    public final List<BoostResponse> equipedBoosts;
    public final FightStatisticsResponse totalFightStatistics;
    
    public ArmedBrutoResponse(ArmedBruto armedBruto) {
        super(armedBruto);
        this.bruto = armedBruto.bruto().uuid();
        this.equipedStuffs = armedBruto.equipedStuffs().stream().map(StuffResponse::new).collect(Collectors.toList());
        this.gainedStuffs = armedBruto.gainedStuffs().stream().map(StuffResponse::new).collect(Collectors.toList());
        this.equipedBoosts = armedBruto.equipedBoosts().stream().map(BoostResponse::new).collect(Collectors.toList());
        this.totalFightStatistics = new FightStatisticsResponse(ArmedBrutoService.totalFightStatistics(armedBruto));
    }
}
