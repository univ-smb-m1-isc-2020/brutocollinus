package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;

public class RenderEntry extends RenderedNode {
    private boolean isEntry;

    public RenderEntry(Entry entry) {
        super(entry);

        this.isEntry = true;
    }
}
