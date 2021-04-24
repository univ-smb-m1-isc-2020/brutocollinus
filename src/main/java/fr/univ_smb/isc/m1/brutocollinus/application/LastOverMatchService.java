package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.LastOverMatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastOverMatchService {
    private LastOverMatchRepository repository;

    public LastOverMatchService(LastOverMatchRepository repository) {
        this.repository = repository;
    }

    public LastOverMatch findByTournamentAndParticipant(Tournament tournament, Player participant) {
        return this.repository.findByTournamentAndParticipant(tournament, participant).orElse(null);
    }

    public void updateAllWithLatestMatch(List<Match> matches, Tournament tournament) {
        for (Match match : matches) {
            Player winnerPlayer = match.winner().bruto().owner();
            Player looserPlayer = match.looser().bruto().owner();
            this.update(match, tournament, winnerPlayer, true);
            this.update(match, tournament, looserPlayer, false);
        }
    }

    private void update(Match match, Tournament tournament, Player participant, boolean hasWon) {
        this.repository.deleteByParticipant(participant);
        LastOverMatch lastOverMatch = new LastOverMatch(match, tournament, participant, hasWon);
        this.repository.save(lastOverMatch);
    }
}
