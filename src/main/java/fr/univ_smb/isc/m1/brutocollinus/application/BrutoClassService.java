package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.BrutoClassRepository;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.FightStatistics;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.FightStatisticsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BrutoClassService {
    private final BrutoClassRepository repository;
    private final FightStatisticsRepository fightStatisticsRepository;

    public BrutoClassService(BrutoClassRepository repository, FightStatisticsRepository fightStatisticsRepository) {
        this.repository = repository;
        this.fightStatisticsRepository = fightStatisticsRepository;
    }

    @PostConstruct
    public void initialize() {
        if (this.repository.findAll().isEmpty()) {
            FightStatistics assassinStatistics = new FightStatistics(100, 15, 110);
            this.fightStatisticsRepository.saveAndFlush(assassinStatistics);
            this.repository.saveAndFlush(new BrutoClass("assassin", assassinStatistics));

            FightStatistics valkyrieStatistics = new FightStatistics(300, 25, 80);
            this.fightStatisticsRepository.saveAndFlush(valkyrieStatistics);
            this.repository.saveAndFlush(new BrutoClass("valkyrie", valkyrieStatistics));
        }
    }

    public BrutoClass findByName(String name) {
        return this.repository.findByName(name);
    }
}
