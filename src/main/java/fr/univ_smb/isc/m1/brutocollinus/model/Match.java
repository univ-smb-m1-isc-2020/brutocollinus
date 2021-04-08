package fr.univ_smb.isc.m1.brutocollinus.model;

public class Match {
    private Match leftMatch;
    private Match rightMatch;
    private Match parentMatch;

    private Bruto leftOpponent;
    private Bruto rightOpponent;
    private Bruto winner;

    public Match(Match parentMatch) {
        this.parentMatch = parentMatch;
    }

    public Match() {
        this(null);
    }

    public void setOpponents(Bruto leftOpponent, Bruto rightOpponent) {
        this.leftOpponent = leftOpponent;
        this.rightOpponent = rightOpponent;
    }

    public void resolve() {
        Battle battle = new Battle(this.leftOpponent, this.rightOpponent);
        this.winner = battle.fight();
    }

    public Bruto leftOpponent() {
        return this.leftOpponent;
    }

    public Bruto rightOpponent() {
        return this.rightOpponent;
    }
}
