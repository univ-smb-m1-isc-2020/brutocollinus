package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;

public class BoostRenderer {
    public String name;

    public BoostRenderer(Boost boost) {
        this.name = boost.name();
    }
}
