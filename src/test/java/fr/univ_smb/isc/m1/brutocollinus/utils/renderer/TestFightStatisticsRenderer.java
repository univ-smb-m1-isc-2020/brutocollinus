package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestFightStatisticsRenderer {
    @Test
    void shouldHaveSameDataWhenCreatedFromDb() {
        FightStatistics fightStatistics = new FightStatistics(1, 2, 3);

        FightStatisticsRenderer renderer = new FightStatisticsRenderer(fightStatistics);

        assertEquals(1, renderer.atk);
        assertEquals(2, renderer.hp);
        assertEquals(3, renderer.ini);
    }

    @Test
    void shouldHaveSameDataWhenCreatedFromVector() {
        FightStatisticsVector fightStatistics = new FightStatisticsVector(1, 2, 3);

        FightStatisticsRenderer renderer = new FightStatisticsRenderer(fightStatistics);

        assertEquals(1, renderer.atk);
        assertEquals(2, renderer.hp);
        assertEquals(3, renderer.ini);
    }
}
