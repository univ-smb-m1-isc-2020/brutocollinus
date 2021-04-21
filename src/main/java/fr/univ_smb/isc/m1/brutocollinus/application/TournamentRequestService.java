package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TournamentRequestService {
    private final TournamentRequestRepository repository;

    public TournamentRequestService(TournamentRequestRepository repository) {
        this.repository = repository;
    }

    public TournamentRequest create(String name, Set<Player> guests) {
        TournamentRequest request = new TournamentRequest(name, guests);
        this.repository.save(request);
        return request;
    }

    public void accept(TournamentRequest request, Player player, ArmedBruto armedBruto) {
        if (request.guests().contains(player) && !request.acceptedGuests().contains(player)) {
            request.addAcceptedGuest(player, armedBruto);
            this.repository.save(request);
        }
    }

    public boolean allGuestAccepted(TournamentRequest request) {
        return request.acceptedGuests().equals(request.guests());
    }

    public TournamentRequest get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    public List<TournamentRequest> all() {
        return this.repository.findAll();
    }
}
