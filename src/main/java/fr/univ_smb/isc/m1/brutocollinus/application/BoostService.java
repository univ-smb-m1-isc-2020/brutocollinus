package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.BoostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BoostService {
    private final BoostRepository repository;

    public BoostService(BoostRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {
        if (this.repository.findAll().isEmpty()) {
            FightStatistics bowStatistics = new FightStatistics(100, 100, 40);
            Boost benediction = new Boost("benediction", bowStatistics);
            this.repository.saveAndFlush(benediction);
        }
    }

    public Boost findByName(String name) {
        return this.repository.findByName(name);
    }

    public List<Boost> findAllByUuid(List<String> uuids) {
        return this.repository.findByUuidIn(uuids);
    }

    public List<Boost> all() {
        return this.repository.findAll();
    }
}
