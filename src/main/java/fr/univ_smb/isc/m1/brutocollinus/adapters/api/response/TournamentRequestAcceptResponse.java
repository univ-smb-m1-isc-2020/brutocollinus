package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.ArmedBrutoController;
import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentRequestController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TournamentRequestAcceptResponse extends RepresentationModel<TournamentRequestAcceptResponse> {
    public TournamentRequestAcceptResponse(TournamentRequest request, ArmedBruto armedBruto) {
        Link tournamentRequestLink = linkTo(methodOn(TournamentRequestController.class).get(request.uuid())).withSelfRel();
        Link armedBrutoLink = linkTo(methodOn(ArmedBrutoController.class).get(armedBruto.uuid())).withRel("bruto");
        this.add(tournamentRequestLink, armedBrutoLink);
    }
}
