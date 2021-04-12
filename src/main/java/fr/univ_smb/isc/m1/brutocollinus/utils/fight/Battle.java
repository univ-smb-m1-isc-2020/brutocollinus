package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;

public class Battle {
    private ArmedBrutoFighter firstFighter;
    private ArmedBrutoFighter secondFighter;

    public Battle(ArmedBruto firstOpponent, FightStatistics firstOpponentStatistics, ArmedBruto secondOpponent, FightStatistics secondOpponentStatistics) {
        this.firstFighter = new ArmedBrutoFighter(firstOpponent, firstOpponentStatistics);
        this.secondFighter = new ArmedBrutoFighter(secondOpponent, secondOpponentStatistics);
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
}
