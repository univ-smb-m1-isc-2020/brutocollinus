package fr.univ_smb.isc.m1.brutocollinus.model.arsenal;

public class BrutoValkyrieClass implements IBrutoClass {
    @Override
    public FightStatistics fightStatistics() {
        return new FightStatistics(300, 25, 80);
    }
}
