package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;

import java.util.List;
import java.util.stream.Collectors;

public class TourRenderer {
    public List<String> nodes;

    public TourRenderer(Tour tour) {
        this.nodes = tour.nodes().stream().map(node -> node.uuid().toString()).collect(Collectors.toList());
    }
}
