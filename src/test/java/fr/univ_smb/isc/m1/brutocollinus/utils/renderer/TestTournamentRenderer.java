package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestTournamentRenderer {
    private Tournament tournament;

    @BeforeEach
    void setup() {
        Bruto bruto = new Bruto("b", null, null);
        ArmedBruto armedBruto1 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());

        Entry entry1 = new Entry(armedBruto1);
        Entry entry2 = new Entry(armedBruto2);
        Match match = new Match();
        match.setChildren(entry1, entry2);

        Tour tour1 = new Tour(List.of(match));
        Tour tour2 = new Tour(List.of(entry1, entry2));

        this.tournament = new Tournament("la finaleeee", Set.of(armedBruto1, armedBruto2), List.of(tour1, tour2), List.of(match), List.of(entry1, entry2));
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        TournamentRenderer renderer = new TournamentRenderer(this.tournament);

        assertEquals("la finaleeee", renderer.name);
        assertEquals(2, renderer.participants.size());
        assertNotNull(renderer.tree);
    }
}
