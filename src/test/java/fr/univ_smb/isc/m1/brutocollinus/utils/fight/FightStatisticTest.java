package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightStatisticTest {
    @Test
    void shouldHaveSameValueWhenCreatedFromEntity() {
        FightStatistics entity = new FightStatistics(1, 2, 3);
        FightStatisticsVector vector = new FightStatisticsVector(entity);

        assertEquals(1, vector.atk());
        assertEquals(2, vector.hp());
        assertEquals(3, vector.ini());
    }

    @Test
    void shouldAddEachStatisticsWhenPlus() {
        FightStatisticsVector vector1 = new FightStatisticsVector(1, 2, 3);
        FightStatisticsVector vector2 = new FightStatisticsVector(4, 5, 6);
        FightStatisticsVector sum = vector1.plus(vector2);

        assertEquals(5, sum.atk());
        assertEquals(7, sum.hp());
        assertEquals(9, sum.ini());
    }
}
