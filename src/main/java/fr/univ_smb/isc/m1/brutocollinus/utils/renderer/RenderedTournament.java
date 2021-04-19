package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Entry;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenderedTournament {
    public Map<String, RenderedArmedBruto> participants;
    public Map<String, RenderedNode> nodes;
    public Map<String, RenderedTour> tours;

    public RenderedTournament(Tournament tournament) {
        this.participants = new HashMap<>();
        this.nodes = new HashMap<>();
        this.tours = new HashMap<>();

        this.renderParticipants(tournament.participants());

        List<Tour> tours = tournament.tours();
        this.renderNodes(tours);
        this.renderTours(tours);
    }

    private void renderNodes(List<Tour> tours) {
        for (Tour tour : tours) {
            for (Node node : tour.nodes()) {

                RenderedNode renderedNode;
                if (node instanceof Match) {
                    renderedNode = new RenderedMatch((Match)node);
                }
                else {
                    renderedNode = new RenderedEntry((Entry)node);
                }

                this.nodes.put(node.uuid(), renderedNode);
            }
        }
    }

    private void renderTours(List<Tour> tours) {
        for (Tour tour : tours) {
            RenderedTour renderTour = new RenderedTour(tour);
            this.tours.put(tour.uuid(), renderTour);
        }
    }

    private void renderParticipants(List<ArmedBruto> participants) {
        for (ArmedBruto participant : participants) {
            RenderedArmedBruto renderedParticipants = new RenderedArmedBruto(participant);
            this.participants.put(participant.uuid(), renderedParticipants);
        }
    }
}
