package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;

public class ArmedBrutoFighter {
    private final ArmedBruto armedBruto;
    private final FightStatistics statistics;
    private int remainingHp;
    private int accumulatedTimeSinceLastAttack;
    private int timeBeforeAttack;

    public ArmedBrutoFighter(ArmedBruto armedBruto, FightStatistics statistics) {
        this.armedBruto = armedBruto;
        this.statistics = statistics;

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
        System.out.println(this.armedBruto.bruto().name() + " attack " + this.remainingHp);
        opponent.defense(this.statistics.atk());
    }

    public void defense(int atk) {
        this.remainingHp -= atk;
        System.out.println(this.armedBruto.bruto().name() + " defense " + this.remainingHp);
    }

    public void play(int minimumTimeBeforeAttack, ArmedBrutoFighter opponent) {
        if (this.canAttackAfterTime(minimumTimeBeforeAttack)) {
            this.attack(opponent);
        }
    }
}
