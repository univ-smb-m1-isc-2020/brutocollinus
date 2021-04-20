package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class MeAllBrutoResponse extends RepresentationModel<MeAllBrutoResponse>{
    public final List<BrutoResponse> brutos;

    public MeAllBrutoResponse(List<BrutoResponse> brutos) {
        this.brutos = brutos;
    }
}
