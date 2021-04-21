package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;

public class NodeRenderer {
    public String selectedBruto;

    public NodeRenderer(Node node) {
        ArmedBruto selectedBruto = node.selectedBruto();
        if (selectedBruto != null) {
            this.selectedBruto = selectedBruto.uuid();
        }
    }
}
