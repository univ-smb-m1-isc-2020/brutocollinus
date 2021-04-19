package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;

import java.util.List;
import java.util.stream.Collectors;

public class TournamentRequestResponse {
    public Long id;
    public String name;
    public List<Long> guests;

    public TournamentRequestResponse(TournamentRequest request) {
        this.id = request.getId();
        this.name = request.name();
        this.guests = request.guests().stream().map(Player::getId).collect(Collectors.toList());
    }
}
