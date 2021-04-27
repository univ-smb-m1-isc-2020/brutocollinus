package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Nameable;

public class NameableResponse extends IdentifiableResponse {
    public final String name;

    public NameableResponse(Nameable nameable) {
        super(nameable);
        this.name = nameable.name();
    }
}
