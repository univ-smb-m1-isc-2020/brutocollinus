package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;
import org.springframework.hateoas.RepresentationModel;

public class NodeRenderer extends RepresentationModel<NodeRenderer> {
    public ArmedBrutoAbstractRenderer selectedBruto;

    public static NodeRenderer renderForMatchOrEntry(Node node) {
        if (node instanceof Match) {
            return new MatchAbstractRenderer((Match)node);
        }
        else {
            return new EntryRenderer((Entry)node);
        }
    }

    public NodeRenderer(Node node) {
        ArmedBruto selectedBrutoInNode = node.selectedBruto();
        if (selectedBrutoInNode != null) {
            this.selectedBruto = new ArmedBrutoAbstractRenderer(selectedBrutoInNode);
        }
    }
}
