package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;

public class FightStatisticsVector {
    private int atk;
    private int hp;
    private int ini;


    public FightStatisticsVector(FightStatistics fightStatistics) {
        this(fightStatistics.atk(), fightStatistics.hp(), fightStatistics.ini());
    }

    public FightStatisticsVector(int atk, int hp, int ini) {
        this.atk = atk;
        this.hp = hp;
        this.ini = ini;
    }

    public int atk() {
        return this.atk;
    }

    public int hp() {
        return this.hp;
    }

    public int ini() {
        return this.ini;
    }

    public FightStatisticsVector plus(FightStatisticsVector other) {
        return new FightStatisticsVector(this.atk + other.atk, this.hp + other.hp, this.ini + other.ini);
    }
}
