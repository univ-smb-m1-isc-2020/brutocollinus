package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.*;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.ArmedBrutoRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmedBrutoService {
    private final ArmedBrutoRepository repository;

    public ArmedBrutoService(ArmedBrutoRepository repository) {
        this.repository = repository;
    }

    public ArmedBruto create(Bruto bruto, List<Stuff> stuffs, List<Boost> boosts) {
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
}
