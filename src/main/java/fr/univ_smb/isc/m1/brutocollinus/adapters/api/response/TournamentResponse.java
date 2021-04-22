package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MeController;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TournamentResponse extends RepresentationModel<TournamentResponse> {
    public final String uuid;
    public final String name;

    public TournamentResponse(Tournament tournament) {
        this.uuid = tournament.uuid();
        this.name = tournament.name();

        Link detailLink = linkTo(methodOn(TournamentController.class).get(this.uuid)).withRel("detail");
        this.add(detailLink);
    }
}
