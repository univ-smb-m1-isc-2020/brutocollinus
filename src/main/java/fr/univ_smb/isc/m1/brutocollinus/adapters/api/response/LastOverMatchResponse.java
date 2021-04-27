package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.LastOverMatch;
import org.springframework.hateoas.RepresentationModel;

public class LastOverMatchResponse extends RepresentationModel<LastOverMatchResponse> {
    public final MatchResponse match;
    public final TournamentResponse tournament;
    public final boolean hasWon;

    public LastOverMatchResponse(LastOverMatch lastOverMatch) {
        this.match = new MatchResponse(lastOverMatch.match());
        this.tournament = new TournamentResponse(lastOverMatch.tournament());
        this.hasWon = lastOverMatch.hasWon();
    }
}
