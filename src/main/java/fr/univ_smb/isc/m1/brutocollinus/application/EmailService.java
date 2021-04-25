package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.TournamentRequestController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendTo(String content, String subject, String to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setText(content);
        mailMessage.setSubject(subject);
        mailMessage.setTo(to);

        this.mailSender.send(mailMessage);
    }

    @Async
    public void sendTournamentRequestByEmailToAllGuests(TournamentRequest request) {
        String tournamentName = request.name();
        WebMvcLinkBuilder acceptTournamentRequestLink = linkTo(methodOn(TournamentRequestController.class).accept(request.uuid(), null));
        String acceptTournamentRequestHref = acceptTournamentRequestLink.toString();

        String subject = String.format("Request on tournament \"%s\"", tournamentName);
        String content = String.format("You have been invited to tournament \"%s\", go to this link to accept: %s", tournamentName, acceptTournamentRequestHref);

        request.guests().forEach(guest -> this.sendTo(content, subject, guest.email()));
    }
}
