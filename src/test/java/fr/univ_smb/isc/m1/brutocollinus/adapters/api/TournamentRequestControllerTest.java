package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.application.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class TournamentRequestControllerTest {

    private TournamentRequestService tournamentRequestService;
    private PlayerService playerService;
    private BrutoService brutoService;
    private ArmedBrutoService armedBrutoService;
    private BoostService boostService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.tournamentRequestService = mock(TournamentRequestService.class);
        this.playerService = mock(PlayerService.class);
        this.brutoService = mock(BrutoService.class);
        this.armedBrutoService = mock(ArmedBrutoService.class);
        this.boostService = mock(BoostService.class);
        this.mockMvc = standaloneSetup(new TournamentRequestController(tournamentRequestService, playerService, brutoService, armedBrutoService, boostService)).build();
    }

    @Test
    public void shouldRequestCreateReturnsGetLink() throws Exception {
        Set<Player> guests = Set.of(new Player("toto", "", ""), new Player("titi", "", ""));

        TournamentRequest request = new TournamentRequest("un pont trop loin", guests);
        when(tournamentRequestService.create(anyString(), anySet()))
                .thenReturn(request);

        mockMvc.perform(post("/api/tournament/request/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"un pont trop loin\", \"guests\": [1, 2]}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/tournament/request/" + request.uuid() + "\"}]}"));
    }

    /*@Test
    public void shouldAcceptCreateArmedBruto() {
        Stuff stuff1 = new Stuff("a", null);
        Stuff stuff2 = new Stuff("b", null);

        List<Stuff> stuffs = List.of(stuff1, stuff2);
        List<Boost> boosts = new ArrayList<>();

        when(this.stuffService.findAllByUuid(anyList()))
                .thenReturn(stuffs);
        when(this.boostService.findAllByUuid(anyList()))
                .thenReturn(boosts);
        when(this.armedBrutoService.create(any(), anyList(), anyList()))
                .thenReturn(new ArmedBruto(null, stuffs, boosts));

        verify(this.armedBrutoService).create(null, );

    }*/
}