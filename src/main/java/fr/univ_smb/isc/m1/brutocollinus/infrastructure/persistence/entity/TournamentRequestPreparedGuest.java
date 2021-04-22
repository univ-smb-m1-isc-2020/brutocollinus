package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class TournamentRequestPreparedGuest extends Identifiable {
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    private ArmedBruto armedBruto;

    public TournamentRequestPreparedGuest() {
        // JPA
    }

    public TournamentRequestPreparedGuest(Player player, ArmedBruto armedBruto) {
        this.player = player;
        this.armedBruto = armedBruto;
    }

    public Player player() {
        return this.player;
    }

    public ArmedBruto armedBruto() {
        return this.armedBruto;
    }
}
