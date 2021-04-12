package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class ProcessTournamentTourTest {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private BrutoClassService brutoClassService;
    @Autowired
    private ArmedBrutoService armedBrutoService;
    private BrutoClass assassinClass;

    @BeforeEach
    void setup() {
        this.assassinClass = this.brutoClassService.findByName("assassin");
    }

    @Test
    void create8PlayersTournament() {
        List<ArmedBruto> participants = new ArrayList<>();

        for (int i = 0; i < 8; ++i) {
            Bruto bruto = new Bruto("Energy_" + i, this.assassinClass, null);
            ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new ArrayList<>(), new ArrayList<>());
            participants.add(armedBruto);
        }

        Tournament tournament = this.tournamentService.create("tournoi", participants);

        List<Tour> tours = tournament.tours();

        for (int i = 0; i < 3; ++i) {
            this.tournamentService.processNextTour(tournament);

            Tour lastTour = tours.get(2 - i);
            for (Node node : lastTour.nodes()) {
                assertNotNull(node.selectedBruto());
            }
        }

        assertNotNull(this.tournamentService.winner(tournament));

        assertTrue("finished", this.tournamentService.isFinished(tournament));
    }

    /*@Test
    void create5PlayersTournament() {
        List<ArmedBruto> participants = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            Bruto bruto = new Bruto("Energy_" + i, this.assassinClass, null);
            ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new ArrayList<>(), new ArrayList<>());
            participants.add(armedBruto);
        }

        Tournament tournament = this.tournamentService.create("tournoi", participants);

        List<Tour> tours = tournament.tours();

        assertEquals(4, tours.size());

        Tour firstTour = tours.get(3);
        Tour secondTour = tours.get(2);
        Tour thirdTour = tours.get(1);
        Tour finalTour = tours.get(0);

        assertEquals(2, firstTour.nodes().size());
        assertEquals(4, secondTour.nodes().size());
        assertEquals(2, thirdTour.nodes().size());
        assertEquals(1, finalTour.nodes().size());

        List<Node> firstTourNodes = firstTour.nodes();
        for (int i = 0; i < 2; ++i) {
            assertEquals(participants.get(i + 3), firstTourNodes.get(i).selectedBruto());
        }

        List<Node> secondTourNodes = secondTour.nodes();
        for (int i = 0; i < 3; ++i) {
            assertEquals(participants.get(i), secondTourNodes.get(i + 1).selectedBruto());
        }
    }

    @Test
    void create7PlayersTournament() {
        List<ArmedBruto> participants = new ArrayList<>();

        for (int i = 0; i < 7; ++i) {
            Bruto bruto = new Bruto("Energy_" + i, this.assassinClass, null);
            ArmedBruto armedBruto = this.armedBrutoService.create(bruto, new ArrayList<>(), new ArrayList<>());
            participants.add(armedBruto);
        }

        Tournament tournament = this.tournamentService.create("tournoi", participants);

        List<Tour> tours = tournament.tours();

        assertEquals(4, tours.size());

        Tour firstTour = tours.get(3);
        Tour secondTour = tours.get(2);
        Tour thirdTour = tours.get(1);
        Tour finalTour = tours.get(0);

        assertEquals(6, firstTour.nodes().size());
        assertEquals(4, secondTour.nodes().size());
        assertEquals(2, thirdTour.nodes().size());
        assertEquals(1, finalTour.nodes().size());

        List<Node> firstTourNodes = firstTour.nodes();
        for (int i = 0; i < 6; ++i) {
            assertEquals(participants.get(i + 1), firstTourNodes.get(i).selectedBruto());
        }

        List<Node> secondTourNodes = secondTour.nodes();
        for (int i = 0; i < 1; ++i) {
            assertEquals(participants.get(i), secondTourNodes.get(i + 3).selectedBruto());
        }
    }*/
}
