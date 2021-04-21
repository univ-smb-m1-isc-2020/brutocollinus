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

        Link allBruto = linkTo(methodOn(MeController.class).allBruto(this.uuid)).withRel("all_bruto");
        Link createBruto = linkTo(methodOn(MeController.class).createBruto(this.uuid, null)).withRel("create_bruto");
        this.add(allBruto, createBruto);
    }
}
