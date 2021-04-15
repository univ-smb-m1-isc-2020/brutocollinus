package fr.univ_smb.isc.m1.brutocollinus.application.tdd;

import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoClassService;
import fr.univ_smb.isc.m1.brutocollinus.application.BrutoService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
class CreateBrutoTest {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private BrutoClassService brutoClassService;
    @Autowired
    private BrutoService brutoService;

    @Test
    void createPlayerWithTwoBrutos() {
        Player lili = playerService.create("lili", "email");

        BrutoClass assasinClass = brutoClassService.findByName("assassin");
        Bruto energy = brutoService.create("energy", assasinClass, lili);

        assertEquals("energy", energy.name());
        assertEquals(lili, energy.owner());

        List<Bruto> brutos = lili.brutos();
        assertEquals(1, brutos.size());
        assertEquals(energy, brutos.get(0));
    }
}
