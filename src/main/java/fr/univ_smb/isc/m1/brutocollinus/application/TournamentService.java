package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
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
    private final MatchRenderService matchRenderService;
    private final ArmedBrutoService armedBrutoService;

    public TournamentService(TournamentRepository repository, MatchService matchService, TournamentRenderService tournamentRenderService,
                             MatchRenderService matchRenderService, ArmedBrutoService armedBrutoService) {
        this.repository = repository;
        this.matchService = matchService;
        this.matchRenderService = matchRenderService;
        this.tournamentRenderService = tournamentRenderService;
        this.armedBrutoService = armedBrutoService;
    }

    public Tournament create(String name, Set<ArmedBruto> participants) {
        TournamentBuilder builder = new TournamentBuilder(participants);
        Tournament tournament = new Tournament(name, participants, builder.tours(), builder.matches(), builder.entries());
        this.repository.save(tournament);
        this.tournamentRenderService.render(tournament);
        this.matchRenderService.renderAll(tournament.matches());

        return tournament;
    }

    public Tournament get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    private List<Match> allMatchesInTour(Tour tour) {
        return tour.nodes().stream()
                .filter(Match.class::isInstance)
                .map(Match.class::cast)
                .collect(Collectors.toList());
    }

    private Tour nextTour(Tournament tournament) {
        List<Tour> tours = tournament.tours();

        final int maxTourIndex = tours.size() - 1;
        final int nextTourIndex = maxTourIndex - tournament.nbTourProcessed() - STARTING_TOUR;

        return tours.get(nextTourIndex);
    }

    public void processNextTour(Tournament tournament) {
        Tour nextTour = this.nextTour(tournament);
        List<Match> matches = this.allMatchesInTour(nextTour);
        /*this.matchService.processAll(matches);

        //tournament.setTourProcessed(tournament.nbTourProcessed() + 1);
        if (this.isFinished(tournament)) {
            tournament.setState(Tournament.State.OVER);
        }*/

        // Render only matches that were processed in tour
        this.matchRenderService.renderAll(matches);
        this.tournamentRenderService.render(tournament);
    }

    private boolean isFinished(Tournament tournament) {
        final int processableTours = tournament.tours().size() - STARTING_TOUR;
        return processableTours == tournament.nbTourProcessed();
    }

    public List<Tournament> allInProgress() {
        return this.repository.findAllByState(Tournament.State.ACTIVE);
    }

    public List<Tournament> allInProgressByParticipant(Player participant) {
        List<ArmedBruto> armedBrutos = participant.brutos().stream()
                .map(this.armedBrutoService::findByBruto)
                .collect(Collectors.toList());

        return this.repository.findDistinctByStateAndParticipantsIn(Tournament.State.ACTIVE, armedBrutos);
    }


    public List<Tournament> all() {
        return this.repository.findAll();
    }
}
