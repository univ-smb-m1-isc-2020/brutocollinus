package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TestMatchRenderer {
    private Entry dummyEntry1;
    private Entry dummyEntry2;
    private ArmedBruto armedBruto1;
    private ArmedBruto armedBruto2;

    @BeforeEach
    void setup() {
        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("", brutoClass, null);
        this.armedBruto1 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        this.armedBruto2 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        this.dummyEntry1 = new Entry(armedBruto1);
        this.dummyEntry2 = new Entry(armedBruto2);
    }

    @Test
    void shouldHaveSameDataWhenCreatedAndNotResolved() {
        Match match = new Match();
        match.setChildren(this.dummyEntry1, this.dummyEntry2);

        MatchRenderer renderer = new MatchRenderer(match);

        assertNotNull(renderer.firstOpponent);
        assertNotNull(renderer.secondOpponent);
        assertNull(renderer.winner);
        assertNull(renderer.looser);
    }

    @Test
    void shouldHaveSameDataWhenCreatedAndResolved() {
        Match match = new Match();
        match.setChildren(this.dummyEntry1, this.dummyEntry2);
        match.setWinnerAndLooser(this.armedBruto1, this.armedBruto2);

        MatchRenderer renderer = new MatchRenderer(match);

        assertNotNull(renderer.firstOpponent);
        assertNotNull(renderer.secondOpponent);
        assertNotNull(renderer.winner);
        assertNotNull(renderer.looser);
    }
}
