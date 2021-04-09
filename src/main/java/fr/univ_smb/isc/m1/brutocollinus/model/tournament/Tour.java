package fr.univ_smb.isc.m1.brutocollinus.model.tournament;

import fr.univ_smb.isc.m1.brutocollinus.model.arsenal.Bruto;

import java.util.ArrayList;
import java.util.Arrays;
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
