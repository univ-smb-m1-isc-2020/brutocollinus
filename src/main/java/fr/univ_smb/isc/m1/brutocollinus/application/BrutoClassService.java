package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.BrutoClassRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BrutoClassService {
    private final BrutoClassRepository repository;

    public BrutoClassService(BrutoClassRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {
        if (this.repository.findAll().isEmpty()) {
            FightStatistics assassinStatistics = new FightStatistics(30, 100, 150);
            this.repository.saveAndFlush(new BrutoClass("assassin", assassinStatistics));

            FightStatistics valkyrieStatistics = new FightStatistics(25, 300, 80);
            this.repository.saveAndFlush(new BrutoClass("valkyrie", valkyrieStatistics));
        }
    }

    public BrutoClass findByName(String name) {
        return this.repository.findByName(name);
    }

    public BrutoClass get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    public List<BrutoClass> all() {
        return this.repository.findAll();
    }
}
