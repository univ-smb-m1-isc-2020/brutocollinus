package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }


    public Player create(String name, String email, String password) {
        Player player = new Player(name, email, password);
        this.repository.save(player);
        return player;
    }

    public Player get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    public Optional<Player> findByEmailAndPassword(String email, String password) {
        return this.repository.findByEmailAndPassword(email, password);
    }
}
