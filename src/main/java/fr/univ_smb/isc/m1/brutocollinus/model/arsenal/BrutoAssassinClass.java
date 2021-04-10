package fr.univ_smb.isc.m1.brutocollinus.model.arsenal;

public class BrutoAssassinClass implements IBrutoClass {
    @Override
    public FightStatistics fightStatistics() {
        return new FightStatistics(100, 15, 110);
    }
}
