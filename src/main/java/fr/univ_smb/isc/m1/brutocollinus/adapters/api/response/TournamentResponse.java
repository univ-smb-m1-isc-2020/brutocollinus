package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TournamentResponse extends NameableResponse {

    public TournamentResponse(Tournament tournament) {
        super(tournament);

        Link detailLink = linkTo(methodOn(TournamentController.class).get(this.uuid)).withRel("detail");
        this.add(detailLink);
    }
}
