package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.StuffRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class StuffService {
    private final StuffRepository repository;

    public StuffService(StuffRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {
        if (this.repository.findAll().isEmpty()) {
            FightStatistics bowStatistics = new FightStatistics(300, 0, 0);
            Stuff bow = new Stuff("bow", bowStatistics);
            this.repository.saveAndFlush(bow);

            FightStatistics swordStatistics = new FightStatistics(300, 0, 0);
            Stuff sword = new Stuff("sword", swordStatistics);
            this.repository.saveAndFlush(sword);

            FightStatistics shieldStatistics = new FightStatistics(300, 0, 0);
            Stuff shield = new Stuff("shield", shieldStatistics);
            this.repository.saveAndFlush(shield);
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
        int randomIndex = new Random().nextInt(stuffs.size());
        return stuffs.get(randomIndex);
    }
}
