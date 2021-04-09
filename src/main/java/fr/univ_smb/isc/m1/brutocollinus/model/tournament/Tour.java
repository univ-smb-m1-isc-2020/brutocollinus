package fr.univ_smb.isc.m1.brutocollinus.model.tournament;

import java.util.List;

public class Tour {
    private List<Node> nodes;

    public Tour(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> nodes() {
        return this.nodes;
    }
}
