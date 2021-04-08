package fr.univ_smb.isc.m1.brutocollinus.model;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private List<Match> matches;

    public Tour(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> matches() {
        return this.matches;
    }

    public void fillWithParticipants(ArrayList<Bruto> remainingParticipants) {
        for (Match match : this.matches) {
            match.setOpponents(remainingParticipants.remove(0), remainingParticipants.remove(0));
        }
    }
}
