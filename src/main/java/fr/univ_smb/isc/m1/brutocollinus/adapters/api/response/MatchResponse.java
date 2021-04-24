package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MatchController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class MatchResponse extends RepresentationModel<MatchResponse> {
    public final String uuid;

    public MatchResponse(Match match) {
        this.uuid = match.uuid();

        Link detailLink = linkTo(methodOn(MatchController.class).get(this.uuid)).withRel("detail");
        this.add(detailLink);
    }
}
