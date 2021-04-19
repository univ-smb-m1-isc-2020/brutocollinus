package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;

import org.springframework.hateoas.RepresentationModel;
import java.util.List;
import java.util.stream.Collectors;

public class TournamentRequestResponse extends RepresentationModel<TournamentRequestResponse> {
    public String name;

    public TournamentRequestResponse(TournamentRequest request) {
        this.name = request.name();
    }
}
