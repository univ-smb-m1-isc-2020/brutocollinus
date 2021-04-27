package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;

public class BrutoResponse extends NameableResponse {
    public final String owner;
    public final BrutoClassResponse brutoClass;

    public BrutoResponse(Bruto bruto) {
        super(bruto);
        this.owner = bruto.owner().uuid();
        this.brutoClass = new BrutoClassResponse(bruto.brutoClass());
    }
}
