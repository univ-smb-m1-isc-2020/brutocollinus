package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;

public class RenderedEntry extends RenderedNode {
    public boolean isEntry;

    public RenderedEntry(Entry entry) {
        super(entry);

        this.isEntry = true;
    }
}
