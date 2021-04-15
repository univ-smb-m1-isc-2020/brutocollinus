package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.AttackRecord;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private ArmedBrutoFighter firstFighter;
    private ArmedBrutoFighter secondFighter;
    private List<AttackRecord> attackRecords;

    public Battle(ArmedBruto firstOpponent, FightStatisticsVector firstOpponentStatistics, ArmedBruto secondOpponent, FightStatisticsVector secondOpponentStatistics) {
        this.firstFighter = new ArmedBrutoFighter(firstOpponent, firstOpponentStatistics, this);
        this.secondFighter = new ArmedBrutoFighter(secondOpponent, secondOpponentStatistics, this);
        this.attackRecords = new ArrayList<>();
    }

    public ArmedBruto fight() {
        final int firstFighterTimeBeforeAttack = firstFighter.timeBeforeAttack();
        final int secondFighterTimeBeforeAttack = secondFighter.timeBeforeAttack();

        final int minimumTimeBeforeAttack = Math.min(firstFighterTimeBeforeAttack, secondFighterTimeBeforeAttack);

        while (this.allFighterAlive()) {
            this.firstFighter.play(minimumTimeBeforeAttack, this.secondFighter);
            if (this.secondFighter.alive()) {
                this.secondFighter.play(minimumTimeBeforeAttack, this.firstFighter);
            }
        }

        if (this.firstFighter.alive()) {
            return this.firstFighter.armedBruto();
        }
        else {
            return this.secondFighter.armedBruto();
        }
    }

    private boolean allFighterAlive() {
        return this.firstFighter.alive() && this.secondFighter.alive();
    }

    public void recordAfterAttack(ArmedBrutoFighter attacker, ArmedBrutoFighter defender, int damage) {
        AttackRecord record = new AttackRecord(attacker.armedBruto(), defender.armedBruto(), damage, defender.remainingHp());
        this.attackRecords.add(record);
    }

    public List<AttackRecord> attackRecords() {
        return this.attackRecords;
    }
}
