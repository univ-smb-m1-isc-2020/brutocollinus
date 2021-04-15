package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {

    private FightStatisticsVector lowPvStatistic;
    private FightStatisticsVector highPvStatistic;
    private FightStatisticsVector lowIniStatistic;
    private FightStatisticsVector highIniStatistic;

    @BeforeEach
    void setup() {
        this.lowPvStatistic = new FightStatisticsVector(100, 100, 100);
        this.highPvStatistic = new FightStatisticsVector(100, 300, 100);

        this.lowIniStatistic = new FightStatisticsVector(100, 100, 100);
        this.highIniStatistic = new FightStatisticsVector(100, 100, 200);
    }

    @Test
    void shouldHigherPvBrutoWinBattle() {
        Bruto bruto1 = new Bruto("bruto1", null, null);
        Bruto bruto2 = new Bruto("bruto2", null, null);

        ArmedBruto armedBruto1 = new ArmedBruto(bruto1, new ArrayList<>(), new ArrayList<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto2, new ArrayList<>(), new ArrayList<>());

        Battle battle = new Battle(armedBruto1, this.lowPvStatistic, armedBruto2, this.highPvStatistic);
        ArmedBruto winner = battle.fight();

        assertEquals(winner, armedBruto2);
    }

    @Test
    void shouldHigherIniBrutoWinBattle() {
        Bruto bruto1 = new Bruto("bruto1", null, null);
        Bruto bruto2 = new Bruto("bruto2", null, null);

        ArmedBruto armedBruto1 = new ArmedBruto(bruto1, new ArrayList<>(), new ArrayList<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto2, new ArrayList<>(), new ArrayList<>());

        Battle battle = new Battle(armedBruto1, this.lowIniStatistic, armedBruto2, this.highIniStatistic);
        ArmedBruto winner = battle.fight();

        assertEquals(winner, armedBruto2);
    }

    @Test
    void shouldHighPvBrutosEndBattleIn3Attacks() {
        Bruto bruto1 = new Bruto("bruto1", null, null);
        Bruto bruto2 = new Bruto("bruto2", null, null);

        ArmedBruto armedBruto1 = new ArmedBruto(bruto1, new ArrayList<>(), new ArrayList<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto2, new ArrayList<>(), new ArrayList<>());

        Battle battle = new Battle(armedBruto1, this.highPvStatistic, armedBruto2, this.highPvStatistic);
        ArmedBruto winner = battle.fight();

        assertEquals(winner, armedBruto1);
        List<AttackRecord> records = battle.attackRecords();

        assertEquals(5, records.size());

        for (int i = 0; i < 2; ++i) {
            AttackRecord record1 = records.get(i * 2);
            AttackRecord record2 = records.get(i * 2 + 1);

            assertEquals(armedBruto1, record1.attacker());
            assertEquals(armedBruto2, record2.attacker());

            assertEquals(armedBruto2, record1.defender());
            assertEquals(armedBruto1, record2.defender());

            assertEquals(100, record1.damage());
            assertEquals(100, record2.damage());
        }
    }
}
