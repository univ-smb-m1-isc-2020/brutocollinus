package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;

public class EntryRenderer extends NodeRenderer {
    public boolean isEntry;

    public EntryRenderer(Entry entry) {
        super(entry);

        this.isEntry = true;
    }
}
