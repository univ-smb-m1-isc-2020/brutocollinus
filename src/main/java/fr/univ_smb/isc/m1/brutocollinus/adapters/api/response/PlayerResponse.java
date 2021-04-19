package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;

public class PlayerResponse {
    public Long id;
    public String name;
    public String email;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.name = player.name();
        this.email = player.email();
    }
}
