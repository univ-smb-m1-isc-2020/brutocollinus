package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.tournament.TourBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository repository;

    public TournamentService(TournamentRepository repository) {
        this.repository = repository;
    }

    public Tournament create(String name, List<ArmedBruto> participants) {
        TourBuilder builder = new TourBuilder(participants);
        Tournament tournament = new Tournament(name, participants, builder.tours());
        this.repository.save(tournament);
        return tournament;
    }
}
