package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;

public class TournamentRequestCreateResponse {
    public Long request;

    public TournamentRequestCreateResponse(TournamentRequest request) {
        this.request = request.getId();
    }
}
