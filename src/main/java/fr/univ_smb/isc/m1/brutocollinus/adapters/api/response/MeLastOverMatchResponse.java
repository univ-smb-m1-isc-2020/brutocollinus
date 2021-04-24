package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.LastOverMatch;

public class MeLastOverMatchResponse {
    public final MatchResponse match;
    public boolean hasWon;

    public MeLastOverMatchResponse(LastOverMatch lastOverMatch) {
        this.match = new MatchResponse(lastOverMatch.match());
        this.hasWon = lastOverMatch.hasWon();
    }
}
