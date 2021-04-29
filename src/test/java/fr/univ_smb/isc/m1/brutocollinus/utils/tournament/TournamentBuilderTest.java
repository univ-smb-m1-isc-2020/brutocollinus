package fr.univ_smb.isc.m1.brutocollinus.utils.tournament;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentBuilderTest {
    Set<ArmedBruto> generateParticipants(int size) {
        Set<ArmedBruto> participants = new HashSet<>();
        for (int i = 0; i < size; ++i) {
            ArmedBruto armedBruto = new ArmedBruto(null, new HashSet<>(), new HashSet<>());
            participants.add(armedBruto);
        }

        return participants;
    }

    @Test
    void should2ParticipantsCreate2Tours() {
        Set<ArmedBruto> participants = this.generateParticipants(2);

        TournamentBuilder builder = new TournamentBuilder(participants);

        List<Tour> tours = builder.tours();
        assertEquals(2, tours.size());

        Tour finalTour = tours.get(0);
        Tour secondTour = tours.get(1);

        assertEquals(1, finalTour.nodes().size());
        assertEquals(2, secondTour.nodes().size());

        Match finalMatch = (Match)finalTour.nodes().get(0);
        assertEquals(secondTour.nodes().get(0), finalMatch.leftChild());
        assertEquals(secondTour.nodes().get(1), finalMatch.rightChild());
    }
}
