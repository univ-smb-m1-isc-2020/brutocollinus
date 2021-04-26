package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestMatchAbstractRenderer {
    private Entry dummyEntry1;
    private Entry dummyEntry2;

    @BeforeEach
    void setup() {
        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("", brutoClass, null);
        ArmedBruto armedBruto = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        this.dummyEntry1 = new Entry(armedBruto);
        this.dummyEntry2 = new Entry(armedBruto);
    }

    @Test
    void shouldHaveSameDataWhenCreatedAndNotResolved() {
        Match match = new Match();
        match.setChildren(this.dummyEntry1, this.dummyEntry2);

        MatchAbstractRenderer matchAbstractRenderer = new MatchAbstractRenderer(match);

        assertEquals(2, matchAbstractRenderer.children.size());
        assertTrue(matchAbstractRenderer.isMatch);
    }
}
