package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestBoostRenderer {
    @Test
    void shouldHaveSameDataWhenCreated() {
        FightStatistics fightStatistics = new FightStatistics(1, 2, 3);
        Boost boost = new Boost("boost!", fightStatistics);

        BoostRenderer renderer = new BoostRenderer(boost);

        assertEquals("boost!", renderer.name);
        assertNotNull(renderer.fightStatistics);
    }
}
