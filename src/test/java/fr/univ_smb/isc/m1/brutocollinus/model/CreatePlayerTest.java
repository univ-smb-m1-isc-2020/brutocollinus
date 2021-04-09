package fr.univ_smb.isc.m1.brutocollinus.model;

import fr.univ_smb.isc.m1.brutocollinus.model.arsenal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

class CreatePlayerTest {
    @Test
    void createPlayer() {
        Player lili = new Player("lili");
        IBrutoClass assassinClass = new BrutoAssassinClass();
        IBrutoClass valkyrieClass = new BrutoValkyrieClass();

        lili.createBruto("Energy", assassinClass);
        lili.createBruto("Eco", valkyrieClass);

        ArrayList<Bruto> brutos = lili.brutos();

        assertEquals(2, brutos.size());

        Bruto energy = brutos.get(0);
        Bruto eco = brutos.get(1);


        assertEquals("Energy", energy.name());
        assertEquals(energy.hp(), assassinClass.hp());
        assertEquals(energy.atk(), assassinClass.atk());
        assertEquals(energy.ini(), assassinClass.ini());

        assertEquals("Eco", eco.name());
        assertEquals(eco.hp(), valkyrieClass.hp());
        assertEquals(eco.atk(), valkyrieClass.atk());
        assertEquals(eco.ini(), valkyrieClass.ini());
    }
}
