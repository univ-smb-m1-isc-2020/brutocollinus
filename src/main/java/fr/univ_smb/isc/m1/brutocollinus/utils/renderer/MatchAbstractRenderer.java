package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.adapters.api.MatchController;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class MatchAbstractRenderer extends NodeRenderer {
    public List<NodeRenderer> children;
    public boolean isMatch;

    public MatchAbstractRenderer(Match match) {
        super(match);

        NodeRenderer leftChildRenderer = NodeRenderer.renderForMatchOrEntry(match.leftChild());
        NodeRenderer rightChildRenderer = NodeRenderer.renderForMatchOrEntry(match.rightChild());
        this.children = List.of(leftChildRenderer, rightChildRenderer);

        this.isMatch = true;

        Link detailLink = linkTo(methodOn(MatchController.class).get(match.uuid())).withRel("detail");
        this.add(detailLink);
    }
}
