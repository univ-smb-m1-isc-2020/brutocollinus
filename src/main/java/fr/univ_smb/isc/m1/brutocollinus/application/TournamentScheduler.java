package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TournamentScheduler {
    private static final Logger log = LoggerFactory.getLogger(TournamentScheduler.class);
    private final TournamentRequestService tournamentRequestService;
    private final TournamentService tournamentService;

    public TournamentScheduler(TournamentRequestService tournamentRequestService, TournamentService tournamentService) {
        this.tournamentRequestService = tournamentRequestService;
        this.tournamentService = tournamentService;
        log.info("Start scheduler");
    }

    @Scheduled(fixedDelay = 120000)
    public void processRequestsAndTournaments() {
        this.createTournamentsFromAcceptedRequests();
        this.processNextTournamentsTour();
    }

    public void createTournamentsFromAcceptedRequests() {
        List<TournamentRequest> requests = this.tournamentRequestService.allWithoutTournament();
        log.info("{} awaiting requests", requests.size());

        for (TournamentRequest request : requests) {
            if (this.tournamentRequestService.allGuestAccepted(request)) {
                String requestName = request.name();
                log.info("Create tournament for request: {}", requestName);
                //this.tournamentRequestService.transformToTournament(request));
            }
        }
    }

    public void processNextTournamentsTour() {
        List<Tournament> tournaments = this.tournamentService.allInProgress();
        log.info("{} tournaments in progress", tournaments.size());

        for (Tournament tournament : tournaments) {
            String tournamentName = tournament.name();
            log.info("Process next tour for tournament :{}", tournamentName);
            this.tournamentService.processNextTour(tournament);
        }
    }
}
