package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.ArmedBrutoRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmedBrutoService {
    private final ArmedBrutoRepository repository;
    private final StuffService stuffService;

    public ArmedBrutoService(ArmedBrutoRepository repository, StuffService stuffService) {
        this.repository = repository;
        this.stuffService = stuffService;
    }

    public ArmedBruto create(Bruto bruto, List<Boost> boosts) {
        Stuff firstStuff = this.stuffService.randomStuff();
        List<Stuff> stuffs = List.of(firstStuff);
        ArmedBruto armedBruto = new ArmedBruto(bruto, stuffs, boosts);
        this.repository.save(armedBruto);
        return armedBruto;
    }

    public FightStatisticsVector totalStatistics(ArmedBruto armedBruto) {
        FightStatisticsVector classStatistics = new FightStatisticsVector(armedBruto.bruto().brutoClass().fightStatistics());
        FightStatisticsVector totalStatistics = classStatistics;

        totalStatistics = armedBruto.stuffs().stream()
                .map((stuff) -> new FightStatisticsVector(stuff.fightStatistics()))
                .reduce(totalStatistics, (s1, s2) -> s1.plus(s2));

        totalStatistics = armedBruto.boosts().stream()
                .map((boost) -> new FightStatisticsVector(boost.fightStatistics()))
                .reduce(totalStatistics, (s1, s2) -> s1.plus(s2));

        return totalStatistics;
    }

    public ArmedBruto get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    public ArmedBruto findByBruto(Bruto bruto) {
        return this.repository.findByBruto(bruto).orElse(null);
    }
}
