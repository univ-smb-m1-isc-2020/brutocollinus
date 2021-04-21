package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.TournamentRequestRepository;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Set.of;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TournamentRequestServiceTest {
    TournamentRequestService tournamentRequestService;
    private Player player1;
    private Player player2;
    private TournamentRequest request;

    @BeforeEach
    void setup() {
        TournamentRequestRepository repository = mock(TournamentRequestRepository.class);
        this.tournamentRequestService = new TournamentRequestService(repository, null);

        this.player1 = new Player("billy", "", "");
        this.player2 = new Player("roger", "", "");
        this.request = this.tournamentRequestService.create("un pont trop loin", of(player1, player2));
    }

    @Test
    void shouldCreateRequestWithGuestAndName() {
        assertEquals("un pont trop loin", this.request.name());
        assertThat(this.request.guests(), containsInAnyOrder(this.player1, this.player2));
        assertEquals(0, this.request.acceptedGuests().size());
    }

    @Test
    void shouldAddArmedBrutoWhenGuestAccept() {
        ArmedBruto armedBruto = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
        this.tournamentRequestService.accept(this.request, this.player1, armedBruto);

        assertThat(this.request.acceptedGuests(), contains(this.player1));
        assertThat(this.request.armedBrutos(), contains(armedBruto));
        assertFalse(this.tournamentRequestService.allGuestAccepted(this.request));
    }

    @Test
    void shouldAllGuestAcceptedTrueWhenALlGuestAccept() {
        ArmedBruto armedBruto1 = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());
        ArmedBruto armedBruto2 = new ArmedBruto(null, new ArrayList<>(), new ArrayList<>());

        this.tournamentRequestService.accept(this.request, this.player1, armedBruto1);
        this.tournamentRequestService.accept(this.request, this.player2, armedBruto2);

        assertTrue(this.tournamentRequestService.allGuestAccepted(this.request));
    }
}
