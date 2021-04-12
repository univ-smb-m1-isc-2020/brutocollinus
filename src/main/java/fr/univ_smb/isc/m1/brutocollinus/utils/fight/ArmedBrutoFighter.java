package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;

public class ArmedBrutoFighter {
    private final ArmedBruto armedBruto;
    private final FightStatistics statistics;
    private final Battle battle;
    private int remainingHp;
    private int accumulatedTimeSinceLastAttack;
    private int timeBeforeAttack;

    public ArmedBrutoFighter(ArmedBruto armedBruto, FightStatistics statistics, Battle battle) {
        this.armedBruto = armedBruto;
        this.statistics = statistics;
        this.battle = battle;

        this.remainingHp = statistics.hp();
        this.timeBeforeAttack = 1000 / statistics.ini();
        this.accumulatedTimeSinceLastAttack = 0;
    }

    public boolean canAttackAfterTime(int time) {
        this.accumulatedTimeSinceLastAttack += time;

        if (this.accumulatedTimeSinceLastAttack >= this.timeBeforeAttack) {
            this.accumulatedTimeSinceLastAttack -= this.timeBeforeAttack;

            return true;
        }

        return false;
    }

    public ArmedBruto armedBruto() {
        return this.armedBruto;
    }

    public int timeBeforeAttack() {
        return this.timeBeforeAttack;
    }

    public boolean alive() {
        return this.remainingHp > 0;
    }

    public void attack(ArmedBrutoFighter opponent) {
        final int damage = this.statistics.atk();
        opponent.defense(damage);

        battle.recordAfterAttack(this, opponent, damage);
    }

    public void defense(int atk) {
        this.remainingHp -= atk;
    }

    public void play(int minimumTimeBeforeAttack, ArmedBrutoFighter opponent) {
        if (this.canAttackAfterTime(minimumTimeBeforeAttack)) {
            this.attack(opponent);
        }
    }

    public int remainingHp() {
        return this.remainingHp;
    }
}
