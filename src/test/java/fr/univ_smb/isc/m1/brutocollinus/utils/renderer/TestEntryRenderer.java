package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestEntryRenderer {
    private ArmedBruto armedBruto;

    @BeforeEach
    void setup() {
        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("billy", brutoClass, null);
        this.armedBruto = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        Entry entry = new Entry(this.armedBruto);

        EntryRenderer entryRenderer = new EntryRenderer(entry);

        assertEquals("billy", entryRenderer.selectedBruto.name);
        assertTrue(entryRenderer.isEntry);
    }
}
