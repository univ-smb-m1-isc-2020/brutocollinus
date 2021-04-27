package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MeController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class PlayerResponse extends NameableResponse {
    public final String email;

    public PlayerResponse(Player player) {
        super(player);
        this.email = player.email();

        Link allBrutoLink = linkTo(methodOn(MeController.class).allBruto(this.uuid)).withRel("all_bruto");
        Link allBrutoAvailableLink = linkTo(methodOn(MeController.class).allBrutoAvailable(this.uuid)).withRel("all_available_bruto");
        Link createBrutoLink = linkTo(methodOn(MeController.class).createBruto(this.uuid, null)).withRel("create_bruto");
        Link allTournamentLink = linkTo(methodOn(MeController.class).allTournamentInProgress(this.uuid)).withRel("all_in_progress_tournament");
        Link allLastOverMatchLink = linkTo(methodOn(MeController.class).allLastOverMatch(this.uuid)).withRel("all_last_over_match");
        this.add(allBrutoLink, allBrutoAvailableLink, createBrutoLink, allTournamentLink, allLastOverMatchLink);
    }
}
