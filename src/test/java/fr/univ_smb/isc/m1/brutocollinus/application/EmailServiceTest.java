package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailServiceTest {
    private EmailService emailService;
    private JavaMailSender mailSender;

    @BeforeEach
    void setup() {
        this.mailSender = mock(JavaMailSender.class);
        this.emailService = new EmailService(this.mailSender);
    }

    @Test
    void shouldSendEmailForEachParticipant() {
        Player p1 = new Player("toto", "toto@gmail.com", "");
        Player p2 = new Player("tata", "tata@gmail.com", "");
        TournamentRequest request = new TournamentRequest("", new LinkedHashSet<>(List.of(p1, p2)));

        this.emailService.sendTournamentRequestByEmailToAllGuests(request);

        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(this.mailSender, times(2)).send(captor.capture());
        List<SimpleMailMessage> messages = captor.getAllValues();
        assertEquals("toto@gmail.com", messages.get(0).getTo()[0]);
        assertEquals("tata@gmail.com", messages.get(1).getTo()[0]);
    }
}
