package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class TournamentRequest {
    @Id
    @GeneratedValue
    private Long id;

    public String name;

    @ManyToMany
    private Set<Player> guests;

    @ManyToMany
    private Map<Player, ArmedBruto> acceptedGuestToArmedBrutos;

    public TournamentRequest() {
        // JPA
    }

    public TournamentRequest(String name, Set<Player> guests) {
        this.name = name;
        this.guests = guests;
        this.acceptedGuestToArmedBrutos = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Player> guests() {
        return this.guests;
    }

    public String name() {
        return this.name;
    }

    public Set<Player> acceptedGuests() {
        return this.acceptedGuestToArmedBrutos.keySet();
    }

    public List<ArmedBruto> armedBrutos() {
        return new ArrayList<ArmedBruto>(this.acceptedGuestToArmedBrutos.values());
    }

    public void acceptGuest(Player player, ArmedBruto armedBruto) {
        this.acceptedGuestToArmedBrutos.put(player, armedBruto);
    }
}
