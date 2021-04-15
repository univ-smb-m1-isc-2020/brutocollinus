package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;

public class RenderedMatch extends RenderedNode {
    public Long leftChild;
    public Long rightChild;
    public boolean isMatch;

    public RenderedMatch(Match match) {
        super(match);

        this.leftChild = match.leftChild().getId();
        this.rightChild = match.rightChild().getId();
        this.isMatch = true;
    }
}
