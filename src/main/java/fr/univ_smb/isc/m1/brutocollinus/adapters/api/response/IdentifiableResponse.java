package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Identifiable;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Nameable;
import org.springframework.hateoas.RepresentationModel;

public class IdentifiableResponse extends RepresentationModel<IdentifiableResponse> {
    public final String uuid;

    public IdentifiableResponse(Identifiable identifiable) {
        this.uuid = identifiable.uuid();
    }
}
