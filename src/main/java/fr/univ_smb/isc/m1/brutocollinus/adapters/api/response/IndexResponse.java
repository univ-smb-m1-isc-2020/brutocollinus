package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class IndexResponse extends RepresentationModel<IndexResponse> {
    public IndexResponse() {
        Link loginLink = linkTo(methodOn(AuthController.class).login(null)).withRel("login");
        Link registerLink = linkTo(methodOn(AuthController.class).register(null)).withRel("register");
        Link searchPlayerLink = linkTo(methodOn(PlayerController.class).search(null)).withRel("search_player");
        Link allStuffLink = linkTo(methodOn(StuffController.class).allStuff()).withRel("all_stuff");
        Link allBoostLink = linkTo(methodOn(BoostController.class).allBoost()).withRel("all_boost");
        Link allBrutoClassLink = linkTo(methodOn(BrutoClassController.class).allBrutoClass()).withRel("all_bruto_class");
        Link createTournamentRequestLink = linkTo(methodOn(TournamentRequestController.class).create(null)).withRel("create_tournament_request");
        this.add(loginLink, registerLink, searchPlayerLink, allStuffLink, allBoostLink, allBrutoClassLink, createTournamentRequestLink);
    }
}
