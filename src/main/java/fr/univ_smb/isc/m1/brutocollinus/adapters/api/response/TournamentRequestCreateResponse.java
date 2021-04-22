package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentRequestController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TournamentRequestCreateResponse extends RepresentationModel<TournamentRequestResponse> {
    public TournamentRequestCreateResponse(TournamentRequest request) {
        Link getLink = linkTo(methodOn(TournamentRequestController.class).get(request.uuid())).withSelfRel();
        this.add(getLink);
    }
}
