package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.ArmedBrutoController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ArmedBrutoAbstractRenderer extends RepresentationModel<ArmedBrutoRenderer> {
    public String name;

    public ArmedBrutoAbstractRenderer(ArmedBruto participant) {
        Bruto bruto = participant.bruto();

        this.name = bruto.name();

        Link currentStateLink = linkTo(methodOn(ArmedBrutoController.class).get(participant.uuid())).withRel("current_state");
        this.add(currentStateLink);
    }
}
