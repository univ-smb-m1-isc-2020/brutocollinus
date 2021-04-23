package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestEntryRenderer {
    private ArmedBruto bruto;

    @BeforeEach
    void setup() {
        this.bruto = new ArmedBruto(null, new HashSet<>(), new HashSet<>());
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        Entry entry = new Entry(this.bruto);

        EntryRenderer entryRenderer = new EntryRenderer(entry);

        assertEquals(this.bruto.uuid(), entryRenderer.selectedBruto);
        assertTrue(entryRenderer.isEntry);
    }
}
