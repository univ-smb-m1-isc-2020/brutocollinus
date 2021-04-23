package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.stream.Collectors;

public class ArmedBrutoResponse extends RepresentationModel<ArmedBrutoResponse> {
    public final String uuid;
    public final String bruto;
    public final List<StuffResponse> stuffs;
    public final List<BoostResponse> boosts;

    public ArmedBrutoResponse(ArmedBruto armedBruto) {
        this.uuid = armedBruto.uuid();
        this.bruto = armedBruto.bruto().uuid();
        this.stuffs = armedBruto.equipedStuffs().stream().map(StuffResponse::new).collect(Collectors.toList());
        this.boosts = armedBruto.equipedBoosts().stream().map(BoostResponse::new).collect(Collectors.toList());
    }
}
