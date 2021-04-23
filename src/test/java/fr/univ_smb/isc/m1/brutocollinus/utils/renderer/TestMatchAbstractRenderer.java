package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestMatchAbstractRenderer {
    private Entry dummyEntry1;
    private Entry dummyEntry2;

    @BeforeEach
    void setup() {
        ArmedBruto bruto = new ArmedBruto(null, new HashSet<>(), new HashSet<>());
        this.dummyEntry1 = new Entry(bruto);
        this.dummyEntry2 = new Entry(bruto);
    }

    @Test
    void shouldHaveSameDataWhenCreatedAndNotResolved() {
        Match match = new Match();
        match.setChildren(this.dummyEntry1, this.dummyEntry2);

        MatchAbstractRenderer matchAbstractRenderer = new MatchAbstractRenderer(match);

        assertEquals(this.dummyEntry1.uuid(), matchAbstractRenderer.leftChild);
        assertEquals(this.dummyEntry2.uuid(), matchAbstractRenderer.rightChild);
        assertTrue(matchAbstractRenderer.isMatch);
    }
}
