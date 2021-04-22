package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAttackRecordRenderer {
    private ArmedBruto attacker;
    private ArmedBruto defender;

    @BeforeEach
    void setup() {
        this.attacker = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
        this.defender = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void shouldHaveSameDataWhenCreated() {
        AttackRecord record = new AttackRecord(this.attacker, this.defender, 100, 1300);

        AttackRecordRenderer rendered = new AttackRecordRenderer(record);

        assertEquals(this.attacker.uuid(), rendered.attacker);
        assertEquals(this.defender.uuid(), rendered.defender);
        assertEquals(100, rendered.damage);
        assertEquals(1300, rendered.defenderHp);
    }
}
