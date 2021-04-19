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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/*@Disabled
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
    void processAllToursOf8ParticipantsTournament() {
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
}*/
