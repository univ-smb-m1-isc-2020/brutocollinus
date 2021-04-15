package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRenderedEntry {
    private ArmedBruto bruto;

    @BeforeEach
    void setup() {
        this.bruto = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
        this.bruto.setId(1L);
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        Entry entry = new Entry(this.bruto);

        RenderedEntry renderedEntry = new RenderedEntry(entry);

        assertEquals(1L, renderedEntry.selectedBruto);
        assertTrue(renderedEntry.isEntry);
    }
}
