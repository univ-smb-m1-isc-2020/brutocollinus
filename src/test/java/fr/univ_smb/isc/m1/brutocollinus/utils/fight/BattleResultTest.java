package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleResultTest {
    @Test
    void shouldBattleResultDataBeCopiedToMatch() {
        Match match = new Match();
        ArmedBruto armedBruto1 = new ArmedBruto(null, new HashSet<>(), new HashSet<>());
        ArmedBruto armedBruto2 = new ArmedBruto(null, new HashSet<>(), new HashSet<>());
        List<AttackRecord> attackRecords = List.of(new AttackRecord(armedBruto1, armedBruto2, 10, 100));

        BattleResult battleResult = new BattleResult(armedBruto1, armedBruto2, attackRecords);

        battleResult.copyToMatch(match);

        assertEquals(armedBruto1, match.winner());
        assertEquals(armedBruto2, match.looser());
        assertEquals(attackRecords, match.attackRecords());
    }
}
