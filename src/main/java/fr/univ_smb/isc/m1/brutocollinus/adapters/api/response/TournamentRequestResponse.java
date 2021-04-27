package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentRequestController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TournamentRequestResponse extends NameableResponse {
    public TournamentRequestResponse(TournamentRequest request) {
        super(request);

        Link acceptLink = linkTo(methodOn(TournamentRequestController.class).accept(uuid, null)).withRel("accept");
        Link getLink = linkTo(methodOn(TournamentRequestController.class).get(uuid)).withSelfRel();
        this.add(getLink, acceptLink);
    }
}
