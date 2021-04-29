package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRepository;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Set.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TournamentServiceTest {
    private TournamentService tournamentService;
    private Tournament tournament;
    private ArmedBruto armedBruto1;
    private ArmedBruto armedBruto2;


    @BeforeEach
    void setup() {
        TournamentRepository repository = mock(TournamentRepository.class);
        TournamentRenderService tournamentRenderService = mock(TournamentRenderService.class);
        MatchRenderService matchRenderService = mock(MatchRenderService.class);
        this.tournamentService = new TournamentService(repository, null, tournamentRenderService, matchRenderService, null, null);

        BrutoClass brutoClass = new BrutoClass("", new FightStatistics(1, 2, 3));
        Bruto bruto = new Bruto("", brutoClass, null);
        this.armedBruto1 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        this.armedBruto2 = new ArmedBruto(bruto, new HashSet<>(), new HashSet<>());
        this.tournament = this.tournamentService.create("un pont trop loin", of(this.armedBruto1, this.armedBruto2));
    }

    @Test
    void shouldCreateTournamentWithNameAndParticipants() {
        assertEquals("un pont trop loin", this.tournament.name());
        assertThat(this.tournament.participants(), containsInAnyOrder(this.armedBruto1, this.armedBruto2));
        assertEquals(2, this.tournament.participants().size());
    }
}
