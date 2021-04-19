package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.tournament.TourBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {
    private static final int STARTING_TOUR = 1;

    private final TournamentRepository repository;
    private final MatchService matchService;

    public TournamentService(TournamentRepository repository, MatchService matchService) {
        this.repository = repository;
        this.matchService = matchService;
    }

    public Tournament create(String name, List<ArmedBruto> participants) {
        TourBuilder builder = new TourBuilder(participants);
        Tournament tournament = new Tournament(name, participants, builder.tours());
        this.repository.save(tournament);
        return tournament;
    }

    public Tournament get(Long id) {
        return this.repository.findById(id).get();
    }

    private void processAllMatchesInTour(Tour tour) {
        for (Node node : tour.nodes()) {
            if (node instanceof Match) {
                Match match = (Match)node;
                matchService.process(match);
            }
        }
    }

    private Tour nextTour(Tournament tournament) {
        List<Tour> tours = tournament.tours();

        final int maxTourIndex = tours.size() - 1;
        final int nextTourIndex = maxTourIndex - tournament.nbTourProcessed - STARTING_TOUR;

        Tour nextTour = tours.get(nextTourIndex);
        return nextTour;
    }

    public void processNextTour(Tournament tournament) {
        Tour nextTour = this.nextTour(tournament);
        this.processAllMatchesInTour(nextTour);

        ++tournament.nbTourProcessed;
    }

    public boolean isFinished(Tournament tournament) {
        final int processableTours = tournament.tours().size() - STARTING_TOUR;
        return processableTours == tournament.nbTourProcessed;
    }

    public ArmedBruto winner(Tournament tournament) {
        Tour finalTour = tournament.tours().get(0);
        Node finalNode = finalTour.nodes().get(0);

        return finalNode.selectedBruto();
    }
}
