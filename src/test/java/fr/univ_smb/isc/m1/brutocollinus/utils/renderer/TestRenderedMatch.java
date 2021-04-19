package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRenderedMatch {
    private Entry dummyEntry1;
    private Entry dummyEntry2;

    @BeforeEach
    void setup() {
        ArmedBruto bruto = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
        this.dummyEntry1 = new Entry(bruto);
        this.dummyEntry2 = new Entry(bruto);
    }

    @Test
    void shouldHaveSameDataWhenCreatedAndNotResolved() {
        Match match = new Match();
        match.setChildren(this.dummyEntry1, this.dummyEntry2);

        RenderedMatch renderedMatch = new RenderedMatch(match);

        assertEquals(this.dummyEntry1.uuid(), renderedMatch.leftChild);
        assertEquals(this.dummyEntry2.uuid(), renderedMatch.rightChild);
        assertTrue(renderedMatch.isMatch);
    }
}
