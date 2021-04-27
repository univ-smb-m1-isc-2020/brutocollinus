package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Node;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tour;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TournamentRenderer {
    public String name;
    public Map<String, ArmedBrutoAbstractRenderer> participants;
    public NodeRenderer tree;

    public TournamentRenderer(Tournament tournament) {
        this.name = tournament.name();
        this.participants = new HashMap<>();

        this.renderParticipants(tournament.participants());

        Tour firstTour = tournament.tours().get(0);
        Node finalNode = firstTour.nodes().get(0);
        this.tree = NodeRenderer.renderForMatchOrEntry(finalNode);
    }

    private void renderParticipants(Set<ArmedBruto> participants) {
        for (ArmedBruto participant : participants) {
            ArmedBrutoAbstractRenderer renderedParticipants = new ArmedBrutoAbstractRenderer(participant);
            this.participants.put(participant.uuid(), renderedParticipants);
        }
    }
}
