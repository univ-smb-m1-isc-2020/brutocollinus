package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class TournamentRequest extends Identifiable {
    private String name;

    @ManyToMany
    @JoinTable(name="tournamentrequest_player")
    private Set<Player> guests;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TournamentRequestPreparedGuest> preparedGuests;

    @ManyToOne
    private Tournament tournament;

    public TournamentRequest() {
        // JPA
    }

    public TournamentRequest(String name, Set<Player> guests) {
        this.name = name;
        this.guests = guests;
        this.preparedGuests = new HashSet<>();
    }

    public Set<Player> guests() {
        return this.guests;
    }

    public String name() {
        return this.name;
    }

    public Set<Player> acceptedGuests() {
        return this.preparedGuests.stream().map(TournamentRequestPreparedGuest::player).collect(Collectors.toSet());
    }

    public Set<ArmedBruto> armedBrutos() {
        return this.preparedGuests.stream().map(TournamentRequestPreparedGuest::armedBruto).collect(Collectors.toSet());
    }

    public void addAcceptedGuest(Player player, ArmedBruto armedBruto) {
        this.preparedGuests.add(new TournamentRequestPreparedGuest(player, armedBruto));
    }
}
