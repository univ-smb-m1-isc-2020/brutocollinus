package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import org.springframework.hateoas.RepresentationModel;

public class MeCreateBrutoResponse extends RepresentationModel<MeCreateBrutoResponse> {
    public final BrutoResponse bruto;

    public MeCreateBrutoResponse(BrutoResponse bruto) {
        this.bruto = bruto;
    }
}
