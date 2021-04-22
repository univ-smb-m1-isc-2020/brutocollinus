package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.tournament.TournamentBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private static final int STARTING_TOUR = 1;

    private final TournamentRepository repository;
    private final MatchService matchService;
    private final TournamentRenderService tournamentRenderService;

    public TournamentService(TournamentRepository repository, MatchService matchService, TournamentRenderService tournamentRenderService) {
        this.repository = repository;
        this.matchService = matchService;
        this.tournamentRenderService = tournamentRenderService;
    }

    public Tournament create(String name, Set<ArmedBruto> participants) {
        TournamentBuilder builder = new TournamentBuilder(participants);
        Tournament tournament = new Tournament(name, participants, builder.tours(), builder.matches(), builder.entries());
        this.repository.save(tournament);
        this.tournamentRenderService.render(tournament);

        return tournament;
    }

    public Tournament get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    private List<Match> allMatchesInTour(Tour tour) {
        return tour.nodes().stream()
                .filter(node -> node instanceof Match)
                .map(node -> (Match)node)
                .collect(Collectors.toList());
    }

    private Tour nextTour(Tournament tournament) {
        List<Tour> tours = tournament.tours();

        final int maxTourIndex = tours.size() - 1;
        final int nextTourIndex = maxTourIndex - tournament.nbTourProcessed - STARTING_TOUR;

        Tour nextTour = tours.get(nextTourIndex);
        return nextTour;
    }

    public void processNextTour(Tournament tournament) {
        /*Tour nextTour = this.nextTour(tournament);
        List<Match> matches = this.allMatchesInTour(nextTour);
        this.matchService.processAll(matches);

        ++tournament.nbTourProcessed;*/

        this.tournamentRenderService.render(tournament);
    }

    public boolean isFinished(Tournament tournament) {
        final int processableTours = tournament.tours().size() - STARTING_TOUR;
        return processableTours == tournament.nbTourProcessed;
    }

    public List<Tournament> allInProgress() {
        return this.repository.findAllByState(Tournament.State.ACTIVE);
    }
}
