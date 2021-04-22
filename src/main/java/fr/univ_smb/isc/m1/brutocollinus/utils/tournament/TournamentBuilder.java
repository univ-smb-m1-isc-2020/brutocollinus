package fr.univ_smb.isc.m1.brutocollinus.utils.tournament;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TournamentBuilder {
    private Set<ArmedBruto> participants;
    private List<Tour> tours;
    private List<Node> nodes;
    private List<Match> matches;
    private List<Entry> entries;

    public TournamentBuilder(Set<ArmedBruto> participants) {
        this.participants = participants;
        this.tours = new ArrayList<>();
        this.nodes = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.entries = new ArrayList<>();

        this.generateAllMatches();
        this.generateAllEntries();
        this.linkMatches();
        this.generateTours();
    }

    private void generateTours() {
        final int nbNodes = this.nodes.size();

        int nbNodesInTour = 1;
        int tourStartNodeIndex = 0;
        while (tourStartNodeIndex < nbNodes) {
            final int tourPastEndNodeIndex = Math.min(tourStartNodeIndex + nbNodesInTour, nbNodes);
            Tour tour = new Tour(this.nodes.subList(tourStartNodeIndex, tourPastEndNodeIndex));
            this.tours.add(tour);

            tourStartNodeIndex += nbNodesInTour;
            nbNodesInTour *= 2;
        }
    }

    private void linkMatches() {
        final int nbParticipants = this.participants.size();
        final int nbMatches = nbParticipants - 1;

        for (int i = 0; i < nbMatches; ++i) {
            final int binaryTreeIndex = i + 1;
            Match match = (Match)this.nodes.get(i);
            Node leftChild = this.nodes.get((binaryTreeIndex * 2) - 1);
            Node rightChild = this.nodes.get((binaryTreeIndex * 2 + 1) - 1);
            match.setChildren(leftChild, rightChild);
        }
    }

    private void generateAllMatches() {
        final int nbParticipants = this.participants.size();
        final int nbMatches = nbParticipants - 1;

        for (int i = 0; i < nbMatches; ++i) {
            Match match = new Match();
            this.nodes.add(match);
            this.matches.add(match);
        }
    }

    private void generateAllEntries() {
        for (ArmedBruto participant : this.participants) {
            Entry entry = new Entry(participant);
            this.nodes.add(entry);
            this.entries.add(entry);
        }
    }

    public List<Tour> tours() {
        return this.tours;
    }

    public List<Match> matches() {
        return this.matches;
    }

    public List<Entry> entries() {
        return this.entries;
    }
}
