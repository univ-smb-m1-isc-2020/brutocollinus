package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestStuffRenderer {
    @Test
    void shouldHaveSameDataWhenCreated() {
        FightStatistics fightStatistics = new FightStatistics(1, 2, 3);
        Stuff stuff = new Stuff("stuff!", fightStatistics);

        StuffRenderer renderer = new StuffRenderer(stuff);

        assertEquals("stuff!", renderer.name);
        assertNotNull(renderer.fightStatistics);
    }
}
