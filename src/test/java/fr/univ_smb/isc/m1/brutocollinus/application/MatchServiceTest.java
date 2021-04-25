package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.BattleResult;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MatchServiceTest {
    private MatchService matchService;

    @BeforeEach
    void setup() {
        ArmedBrutoService armedBrutoService = mock(ArmedBrutoService.class);
        this.matchService = new MatchService(null, armedBrutoService);
    }

    @Test
    void shouldProcessAllProcessEveryMatch() {
        BrutoClass brutoClass = new BrutoClass("class", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("bruto", brutoClass, null);
        ArmedBruto armedBruto1 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        ArmedBruto armedBruto2 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());

        Match match1 = new Match();
        match1.setChildren(new Entry(armedBruto1), new Entry(armedBruto2));
        Match match2 = new Match();
        match2.setChildren(new Entry(armedBruto1), new Entry(armedBruto2));

        List<Match> matches = List.of(match1, match2);
        this.matchService.processAll(matches);

        for (Match match : matches) {
            assertNotNull(match.winner());
            assertNotNull(match.looser());
            assertTrue(match.attackRecords().size() >= 1);
        }
    }
}
