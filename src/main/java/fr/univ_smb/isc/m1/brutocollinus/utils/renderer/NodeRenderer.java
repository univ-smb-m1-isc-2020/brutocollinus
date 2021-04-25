package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;
import org.springframework.hateoas.RepresentationModel;

public class NodeRenderer extends RepresentationModel<NodeRenderer> {
    public String selectedBruto;

    public NodeRenderer(Node node) {
        ArmedBruto selectedBrutoInNode = node.selectedBruto();
        if (selectedBrutoInNode != null) {
            this.selectedBruto = selectedBrutoInNode.uuid();
        }
    }
}
