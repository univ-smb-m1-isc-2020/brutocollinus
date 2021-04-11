package fr.univ_smb.isc.m1.brutocollinus.utils.fight;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;

public class FightStatistics {
    private int atk;
    private int hp;
    private int ini;


    public FightStatistics(fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics fightStatistics) {
        this(fightStatistics.atk(), fightStatistics.hp(), fightStatistics.ini());
    }

    public FightStatistics(int atk, int hp, int ini) {
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

    public FightStatistics plus(FightStatistics other) {
        return new FightStatistics(this.atk + other.atk, this.hp + other.hp, this.ini + other.ini);
    }
}
