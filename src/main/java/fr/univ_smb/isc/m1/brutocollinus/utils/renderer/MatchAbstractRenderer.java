package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MatchController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class MatchAbstractRenderer extends NodeRenderer {
    public String leftChild;
    public String rightChild;
    public boolean isMatch;

    public MatchAbstractRenderer(Match match) {
        super(match);

        this.leftChild = match.leftChild().uuid();
        this.rightChild = match.rightChild().uuid();
        this.isMatch = true;

        Link detailLink = linkTo(methodOn(MatchController.class).get(match.uuid())).withRel("detail");
        this.add(detailLink);
    }
}
