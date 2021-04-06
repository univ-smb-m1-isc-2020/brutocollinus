package fr.univ_smb.isc.m1.brutocollinus.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class CreatePlayer {
    @Test
    public void createPlayer() {
        Player lili = new Player("lili");
        IBrutoClass assassinClass = new BrutoAssassinClass();
        IBrutoClass valkyrieClass = new BrutoValkyrieClass();

        lili.createBruto("Energy", assassinClass);
        lili.createBruto("Eco", valkyrieClass);

        ArrayList<Bruto> brutos = lili.brutos();

        assertEquals(2, brutos.size());

        Bruto energy = brutos.get(0);
        Bruto eco = brutos.get(1);


        assertEquals(energy.name(), "Energy");
        assertEquals(energy.hp(), assassinClass.hp());
        assertEquals(energy.atk(), assassinClass.atk());
        assertEquals(energy.ini(), assassinClass.ini());

        assertEquals(eco.name(), "Eco");
        assertEquals(eco.hp(), valkyrieClass.hp());
        assertEquals(eco.atk(), valkyrieClass.atk());
        assertEquals(eco.ini(), valkyrieClass.ini());
    }
}
