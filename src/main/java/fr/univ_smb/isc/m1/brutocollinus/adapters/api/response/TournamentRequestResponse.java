package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;

import org.springframework.hateoas.RepresentationModel;
import java.util.List;
import java.util.stream.Collectors;

public class TournamentRequestResponse extends RepresentationModel<TournamentRequestResponse> {
    public final String uuid;
    public final String name;

    public TournamentRequestResponse(TournamentRequest request) {
        this.uuid = request.uuid();
        this.name = request.name();
    }
}
