package fr.univ_smb.isc.m1.brutocollinus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTournamentTest {

    @Test
    public void createPairTournament() {
        Player lili = new Player("lili");
        lili.createBruto("Energy", new BrutoAssassinClass());

        Player lulu = new Player("lulu");
        lulu.createBruto("Eco", new BrutoValkyrieClass());
    }
}
