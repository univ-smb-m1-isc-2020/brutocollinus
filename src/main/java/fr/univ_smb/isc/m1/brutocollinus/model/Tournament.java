package fr.univ_smb.isc.m1.brutocollinus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tournament {
    private List<Bruto> participants;
    private ArrayList<Tour> tours;

    public Tournament(List<Bruto> participants) {
        this.participants = participants;
        this.tours = new ArrayList<Tour>();

        this.generateAllTours();
        this.fillFirstAndSecondTourWithParticipants();
    }

    private void generateAllTours() {
        this.generateFinalTour();
        this.generateSecondToHalfFinalTours();
        this.generateFirstTour();
    }

    private void generateFinalTour() {
        Match finalMatch = new Match();
        Tour finalTour = new Tour(Arrays.asList(finalMatch));
        tours.add(finalTour);
    }

    private void generateSecondToHalfFinalTours() {
        final int nbParticipants = this.participants.size();
        final int nbSecondToFinalTour = (int)(Math.log(nbParticipants) / Math.log(2));
        final int smallestPowerOfTwo = (int)Math.pow(2, nbSecondToFinalTour);
    }

    private void generateFirstTour() {
    }

    private void fillFirstAndSecondTourWithParticipants() {
        final int nbTours = this.tours.size();
        ArrayList<Bruto> remainingParticipants = new ArrayList<Bruto>(this.participants);

        Tour firstTour = this.tours.get(nbTours - 1);
        firstTour.fillWithParticipants(remainingParticipants);

        if (nbTours > 1) {
            Tour secondTour = this.tours.get(nbTours - 2);
            secondTour.fillWithParticipants(remainingParticipants);
        }
    }


    public List<Tour> tours() {
        return this.tours;
    }
}
