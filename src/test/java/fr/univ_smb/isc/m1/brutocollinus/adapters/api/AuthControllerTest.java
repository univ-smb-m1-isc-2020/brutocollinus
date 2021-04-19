package fr.univ_smb.isc.m1.brutocollinus.adapters.api;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.form.RegisterForm;
import fr.univ_smb.isc.m1.brutocollinus.application.PlayerService;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ChuckFact;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static java.util.List.of;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class AuthControllerTest {

    private PlayerService playerService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.playerService = mock(PlayerService.class);
        this.mockMvc = standaloneSetup(new AuthController(playerService)).build();
    }

    @Test
    public void shouldRegisterReturnsPlayer() throws Exception {

        when(playerService.create(anyString(), anyString(), anyString()))
                .thenAnswer(invocation -> new Player(invocation.getArgument(0), invocation.getArgument(1), invocation.getArgument(2)));

        mockMvc.perform(post("/api/player/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"titi\", \"email\": \"titi@gmail.com\", \"password\": \"root\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"titi\", \"email\": \"titi@gmail.com\"}"));
    }

    @Test
    public void shouldLoginReturnsPlayer() throws Exception {

        when(playerService.findByEmailAndPassword(anyString(), anyString()))
                .thenReturn(Optional.of(new Player("titi", "titi@gmail.com", "root")));

        mockMvc.perform(post("/api/player/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\": \"titi@gmail.com\", \"password\": \"root\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"titi\", \"email\": \"titi@gmail.com\"}"));
    }
}