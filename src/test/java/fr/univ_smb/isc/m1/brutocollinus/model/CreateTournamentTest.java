package fr.univ_smb.isc.m1.brutocollinus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTournamentTest {

    @Test
    public void createPairTournament() {
        Player lili = new Player("lili");
        lili.createBruto("Energy", new BrutoAssassinClass());

        Player lulu = new Player("lulu");
        lulu.createBruto("Eco", new BrutoValkyrieClass());

        Bruto liliBruto = lili.brutos().get(0);
        Bruto luluBruto = lulu.brutos().get(0);

        List<Bruto> participants = Arrays.asList(liliBruto, lulu.brutos().get(0));
        Tournament tournament = new Tournament(participants);

        List<Tour> tours = tournament.tours();

        assertEquals(1, tours.size());

        Tour finalTour = tours.get(0);
        List<Match> matches = finalTour.matches();

        assertEquals(1, matches.size());

        Match firstMatch = matches.get(0);

        assertEquals(firstMatch.leftOpponent(), liliBruto);
        assertEquals(firstMatch.rightOpponent(), luluBruto);
    }
}
