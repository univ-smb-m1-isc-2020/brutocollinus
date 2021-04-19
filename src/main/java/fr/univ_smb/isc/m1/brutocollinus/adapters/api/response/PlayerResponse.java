package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.hateoas.RepresentationModel;

public class PlayerResponse extends RepresentationModel<PlayerResponse> {
    public String name;
    public String email;

    public PlayerResponse(Player player) {
        this.name = player.name();
        this.email = player.email();
    }
}
