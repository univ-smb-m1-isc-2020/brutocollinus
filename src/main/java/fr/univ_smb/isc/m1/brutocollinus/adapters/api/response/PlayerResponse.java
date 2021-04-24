package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MeController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class PlayerResponse extends RepresentationModel<PlayerResponse> {
    public final String uuid;
    public final String name;
    public final String email;

    public PlayerResponse(Player player) {
        this.uuid = player.uuid();
        this.name = player.name();
        this.email = player.email();

        Link allBrutoLink = linkTo(methodOn(MeController.class).allBruto(this.uuid)).withRel("all_bruto");
        Link createBrutoLink = linkTo(methodOn(MeController.class).createBruto(this.uuid, null)).withRel("create_bruto");
        Link allTournamentLink = linkTo(methodOn(MeController.class).allTournamentInProgress(this.uuid)).withRel("all_in_progress_tournament");
        Link allLastOverMatchLink = linkTo(methodOn(MeController.class).allLastOverMatch(this.uuid)).withRel("all_last_over_match");
        this.add(allBrutoLink, createBrutoLink, allTournamentLink, allLastOverMatchLink);
    }
}
