package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.StuffRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.List;

@Service
public class StuffService {
    private final StuffRepository repository;

    public StuffService(StuffRepository repository) {
        this.repository = repository;
    }

    private void create(String name, int atk, int hp, int ini) {
        FightStatistics statistics = new FightStatistics(atk, hp, ini);
        Stuff stuff = new Stuff(name, statistics);
        this.repository.save(stuff);
    }

    @PostConstruct
    public void initialize() {
        if (this.repository.findAll().isEmpty()) {
            this.create("bow", 300, 0, 0);
            this.create("sword", 400, 0, 0);
            this.create("shield", 0, 200, 0);
        }
    }

    public Stuff findByName(String name) {
        return this.repository.findByName(name);
    }

    public List<Stuff> findAllByUuid(List<String> uuids) {
        return this.repository.findByUuidIn(uuids);
    }

    public List<Stuff> all() {
        return this.repository.findAll();
    }

    public Stuff randomStuff() {
        List<Stuff> stuffs = this.all();
        int randomIndex = new SecureRandom().nextInt(stuffs.size());
        return stuffs.get(randomIndex);
    }
}
