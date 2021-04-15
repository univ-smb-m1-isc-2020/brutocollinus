package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;

import java.util.List;
import java.util.stream.Collectors;

public class RenderedTour {
    public List<String> nodes;

    public RenderedTour(Tour tour) {
        this.nodes = tour.nodes().stream().map(node -> node.getId().toString()).collect(Collectors.toList());
    }
}
