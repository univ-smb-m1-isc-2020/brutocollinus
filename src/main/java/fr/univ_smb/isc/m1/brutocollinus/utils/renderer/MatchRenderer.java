package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;

public class MatchRenderer extends NodeRenderer {
    public String leftChild;
    public String rightChild;
    public boolean isMatch;

    public MatchRenderer(Match match) {
        super(match);

        this.leftChild = match.leftChild().uuid();
        this.rightChild = match.rightChild().uuid();
        this.isMatch = true;
    }
}
