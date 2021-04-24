package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TournamentRequestService {
    private final TournamentRequestRepository repository;
    private final TournamentService tournamentService;
    private final EmailService emailService;

    public TournamentRequestService(TournamentRequestRepository repository, TournamentService tournamentService, EmailService emailService) {
        this.repository = repository;
        this.tournamentService = tournamentService;
        this.emailService = emailService;
    }

    public TournamentRequest create(String name, Set<Player> guests) {
        TournamentRequest request = new TournamentRequest(name, guests);
        this.repository.save(request);
        this.emailService.sendTournamentRequestByEmailToAllGuests(request);
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


    public List<TournamentRequest> allWithoutTournament() {
        return this.repository.findByTournamentIsNull();
    }

    public Tournament transformToTournament(TournamentRequest request) {
        //request TODO
        Tournament tournament = this.tournamentService.create(request.name(), request.armedBrutos());
        return tournament;
    }
}
