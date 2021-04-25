package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TournamentRenderer {
    public Map<String, ArmedBrutoAbstractRenderer> participants;
    public Map<String, NodeRenderer> nodes;
    public Map<String, TourRenderer> tours;

    public TournamentRenderer(Tournament tournament) {
        this.participants = new HashMap<>();
        this.nodes = new HashMap<>();
        this.tours = new HashMap<>();

        this.renderParticipants(tournament.participants());

        List<Tour> allTours = tournament.tours();
        this.renderNodes(allTours);
        this.renderTours(allTours);
    }

    private void renderNodes(List<Tour> tours) {
        for (Tour tour : tours) {
            for (Node node : tour.nodes()) {

                NodeRenderer nodeRenderer;
                if (node instanceof Match) {
                    nodeRenderer = new MatchAbstractRenderer((Match)node);
                }
                else {
                    nodeRenderer = new EntryRenderer((Entry)node);
                }

                this.nodes.put(node.uuid(), nodeRenderer);
            }
        }
    }

    private void renderTours(List<Tour> tours) {
        for (Tour tour : tours) {
            TourRenderer renderTour = new TourRenderer(tour);
            this.tours.put(tour.uuid(), renderTour);
        }
    }

    private void renderParticipants(Set<ArmedBruto> participants) {
        for (ArmedBruto participant : participants) {
            ArmedBrutoAbstractRenderer renderedParticipants = new ArmedBrutoAbstractRenderer(participant);
            this.participants.put(participant.uuid(), renderedParticipants);
        }
    }
}
