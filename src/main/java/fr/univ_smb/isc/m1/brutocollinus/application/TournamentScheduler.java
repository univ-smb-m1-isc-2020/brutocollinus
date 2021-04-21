package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentScheduler {
    private static final Logger log = LoggerFactory.getLogger(TournamentScheduler.class);
    private final TournamentRequestService tournamentRequestService;
    private final TournamentService tournamentService;

    public TournamentScheduler(TournamentRequestService tournamentRequestService, TournamentService tournamentService) {
        this.tournamentRequestService = tournamentRequestService;
        this.tournamentService = tournamentService;
        log.info("Start scheduler");
    }

    @Scheduled(fixedDelay = 5000)
    public void createTournamentsFromAcceptedRequests() {
        List<TournamentRequest> requests = this.tournamentRequestService.allWithoutTournament();
        log.info("{} awaiting requests", requests.size());

        for (TournamentRequest request : requests) {
            if (this.tournamentRequestService.allGuestAccepted(request)) {
                log.info("Create tournament for request: {}", request.name());
                //this.tournamentRequestService.transformToTournament(request));
            }
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void processNextTournamentsTour() {
        List<Tournament> tournaments = this.tournamentService.allInProgress();
        log.info("{} tournaments in progress", tournaments.size());

        for (Tournament tournament : tournaments) {
            log.info("Process next tour for tournament :{}", tournament.name());
            if (!this.tournamentService.isFinished(tournament)) {
                //this.tournamentService.processNextTour(tournament);
            }
        }
    }
}
