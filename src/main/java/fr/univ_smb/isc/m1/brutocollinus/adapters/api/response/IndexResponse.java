package fr.univ_smb.isc.m1.brutocollinus.adapters.api.response;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.AuthController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class IndexResponse extends RepresentationModel<BrutoResponse> {
    public IndexResponse() {
        Link loginLink = linkTo(methodOn(AuthController.class).login(null)).withRel("login");
        Link registerLink = linkTo(methodOn(AuthController.class).register(null)).withRel("register");
        this.add(loginLink, registerLink);
    }
}
