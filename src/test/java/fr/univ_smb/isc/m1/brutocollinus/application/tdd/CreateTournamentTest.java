package fr.univ_smb.isc.m1.brutocollinus.application.tdd;

import fr.univ_smb.isc.m1.brutocollinus.application.TournamentService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.application.ArmedBrutoService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
class CreateTournamentTest {
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
    void createPairTournament() {
        Bruto energy = new Bruto("energy", this.assassinClass, null);
        Bruto eco = new Bruto("eco", this.assassinClass, null);

        ArmedBruto energyArmed = this.armedBrutoService.create(energy, new ArrayList<>(), new ArrayList<>());
        ArmedBruto ecoArmed = this.armedBrutoService.create(eco, new ArrayList<>(), new ArrayList<>());

        List<ArmedBruto> participants = Arrays.asList(energyArmed, ecoArmed);

        Tournament tournament = this.tournamentService.create("tournoi 1", participants);

        assertEquals("tournoi 1", tournament.name());

        List<Tour> tours = tournament.tours();

        assertEquals(participants, tournament.participants());
        assertEquals(2, tours.size());

        Tour secondTour = tours.get(1);
        Tour finalTour = tours.get(0);

        assertEquals(1, finalTour.nodes().size());
        assertEquals(2, secondTour.nodes().size());

        List<Node> nodes = secondTour.nodes();
        assertEquals(2, nodes.size());

        Match match = (Match)finalTour.nodes().get(0);
        Node secondNode = nodes.get(0);
        Node thirdNode = nodes.get(1);

        assertEquals(energyArmed, secondNode.selectedBruto());
        assertEquals(ecoArmed, thirdNode.selectedBruto());

        assertEquals(match.leftChild(), secondNode);
        assertEquals(match.rightChild(), thirdNode);
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

        assertEquals(4, tours.size());

        Tour firstTour = tours.get(3);
        Tour secondTour = tours.get(2);
        Tour thirdTour = tours.get(1);
        Tour finalTour = tours.get(0);

        assertEquals(8, firstTour.nodes().size());
        assertEquals(4, secondTour.nodes().size());
        assertEquals(2, thirdTour.nodes().size());
        assertEquals(1, finalTour.nodes().size());

        List<Node> firstTourNodes = firstTour.nodes();
        for (int i = 0; i < 8; ++i) {
            assertEquals(participants.get(i), firstTourNodes.get(i).selectedBruto());
        }
    }

    @Test
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
    }
}
