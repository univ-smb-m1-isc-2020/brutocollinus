package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo("tristan.porteries@free.fr");
        mailMessage.setSubject("Hello");
        mailMessage.setText("Hello World");

        mailMessage.setFrom("noreply@brutocollinus.oups.net");

        this.mailSender.send(mailMessage);
    }

    public void sendTournamentRequestByEmailToAllGuests(TournamentRequest request) {

    }
}
