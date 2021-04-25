package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Set.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArmedBrutoServiceTest {
    private ArmedBrutoService armedBrutoService;
    private Stuff stuff1;
    private Stuff stuff2;
    private Stuff stuff3;
    private Stuff stuff4;

    @BeforeEach
    void setup() {
        this.stuff1 = new Stuff("stuff1", null);
        this.stuff2 = new Stuff("stuff2", null);
        this.stuff3 = new Stuff("stuff3", null);
        this.stuff4 = new Stuff("stuff4", null);

        this.armedBrutoService = new ArmedBrutoService(null, null);
    }

    @Test
    void shouldHaveOneNewItemFromOtherArmedBruto() {
        ArmedBruto armedBruto1 = new ArmedBruto(null, Set.of(this.stuff1, this.stuff2, this.stuff3), new HashSet<>());
        ArmedBruto armedBruto2 = new ArmedBruto(null, Set.of(this.stuff2, this.stuff4), new HashSet<>());

        this.armedBrutoService.gainOneStuffFromOther(armedBruto1, armedBruto2);
        assertEquals(4, armedBruto1.gainedStuffs().size());
        assertTrue(armedBruto1.gainedStuffs().contains(this.stuff4));
    }

    @Test
    void shouldGainNothingIfNoNewStuffs() {
        ArmedBruto armedBruto1 = new ArmedBruto(null, Set.of(this.stuff2, this.stuff3, this.stuff4), new HashSet<>());
        ArmedBruto armedBruto2 = new ArmedBruto(null, Set.of(this.stuff2, this.stuff3), new HashSet<>());

        this.armedBrutoService.gainOneStuffFromOther(armedBruto1, armedBruto2);
        assertEquals(3, armedBruto1.gainedStuffs().size());
    }

    @Test
    void shouldTotalFightStatisticsBeSumOfClassBoostStuffStatistics() {
        Stuff stuff = new Stuff("", new FightStatistics(100, 200, 300));
        Boost boost = new Boost("", new FightStatistics(400, 500, 600));
        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(700, 800, 900));
        Bruto bruto = new Bruto("", brutoClass, null);
        ArmedBruto armedBruto = new ArmedBruto(bruto, Set.of(stuff), Set.of(boost));

        FightStatisticsVector totalFightStatistics = this.armedBrutoService.totalFightStatistics(armedBruto);
        assertEquals(1200, totalFightStatistics.atk());
        assertEquals(1500, totalFightStatistics.hp());
        assertEquals(1800, totalFightStatistics.ini());
    }
}
