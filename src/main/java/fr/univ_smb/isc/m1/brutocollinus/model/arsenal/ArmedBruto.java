package fr.univ_smb.isc.m1.brutocollinus.model.arsenal;

public class ArmedBruto {
    private String name;
    private IBrutoClass brutoClass;

    public ArmedBruto(String name, IBrutoClass brutoClass) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public FightStatistics fightStatistics() {
        return this.brutoClass.fightStatistics();
    }
}
