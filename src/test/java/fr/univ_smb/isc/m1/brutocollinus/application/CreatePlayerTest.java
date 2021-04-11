package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CreatePlayerTest {
    @Autowired
    private PlayerService playerService;

    @Test
    void createEmptyPlayer() {
        Player lili = playerService.create("lili", "email");

        assertEquals("lili", lili.name());
        assertEquals("email", lili.email());
    }
}
