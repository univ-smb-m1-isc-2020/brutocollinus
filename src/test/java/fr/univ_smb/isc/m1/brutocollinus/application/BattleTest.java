package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {

    private fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatistics lowPvStatistic;
    private fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatistics highPvStatistic;

    @BeforeEach
    void setup() {
        this.lowPvStatistic = new fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatistics(100, 100, 100);
        this.highPvStatistic = new fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatistics(100, 300, 100);
    }

    @Test
    void shouldMorePvPlayerWinBattle() {
        Bruto bruto1 = new Bruto("bruto1", null, null);
        Bruto bruto2 = new Bruto("bruto2", null, null);

        ArmedBruto armedBruto1 = new ArmedBruto(bruto1, new ArrayList<>(), new ArrayList<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto2, new ArrayList<>(), new ArrayList<>());

        Battle battle = new Battle(armedBruto1, this.lowPvStatistic, armedBruto2, this.highPvStatistic);
        ArmedBruto winner = battle.fight();

        assertEquals(winner, armedBruto2);
    }
}
