package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAttackRecordRenderer {
    private ArmedBruto attacker;
    private ArmedBruto defender;

    @BeforeEach
    void setup() {

        Bruto brutoAttacker = new Bruto("a", null, null);
        Bruto brutoDefender = new Bruto("b", null, null);
        this.attacker = new ArmedBruto(brutoAttacker, new HashSet<>(), new HashSet<>());
        this.defender = new ArmedBruto(brutoDefender, new HashSet<>(), new HashSet<>());
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        AttackRecord record = new AttackRecord(this.attacker, this.defender, 100, 1300);

        AttackRecordRenderer rendered = new AttackRecordRenderer(record);

        assertEquals("a", rendered.attacker.name);
        assertEquals("b", rendered.defender.name);
        assertEquals(100, rendered.damage);
        assertEquals(1300, rendered.defenderHp);
    }
}
