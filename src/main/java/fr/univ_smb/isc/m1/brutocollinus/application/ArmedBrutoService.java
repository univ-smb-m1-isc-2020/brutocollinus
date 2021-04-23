package fr.univ_smb.isc.m1.brutocollinus.application;

import com.google.common.collect.Sets;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Boost;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.ArmedBrutoRepository;
import fr.univ_smb.isc.m1.brutocollinus.utils.fight.FightStatisticsVector;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ArmedBrutoService {
    private final ArmedBrutoRepository repository;
    private final StuffService stuffService;

    public ArmedBrutoService(ArmedBrutoRepository repository, StuffService stuffService) {
        this.repository = repository;
        this.stuffService = stuffService;
    }

    public ArmedBruto create(Bruto bruto, Set<Boost> boosts) {
        Stuff firstStuff = this.stuffService.randomStuff();
        Set<Stuff> stuffs = Set.of(firstStuff);
        ArmedBruto armedBruto = new ArmedBruto(bruto, stuffs, boosts);
        this.repository.save(armedBruto);
        return armedBruto;
    }

    public FightStatisticsVector totalStatistics(ArmedBruto armedBruto) {
        FightStatisticsVector totalStatistics = new FightStatisticsVector(armedBruto.bruto().brutoClass().fightStatistics());

        totalStatistics = armedBruto.equipedStuffs().stream()
                .map((stuff) -> new FightStatisticsVector(stuff.fightStatistics()))
                .reduce(totalStatistics, FightStatisticsVector::plus);

        totalStatistics = armedBruto.equipedBoosts().stream()
                .map((boost) -> new FightStatisticsVector(boost.fightStatistics()))
                .reduce(totalStatistics, FightStatisticsVector::plus);

        return totalStatistics;
    }

    public ArmedBruto get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }

    public ArmedBruto findByBruto(Bruto bruto) {
        return this.repository.findByBruto(bruto).orElse(null);
    }

    public void gainOneStuffFromOther(ArmedBruto receivingArmedBruto, ArmedBruto givingArmedBruto) {
        Set<Stuff> newStuffs = Sets.difference(givingArmedBruto.gainedStuffs(), receivingArmedBruto.gainedStuffs());

        if (!newStuffs.isEmpty()) {
            Stuff oneNewStuff = newStuffs.iterator().next();
            receivingArmedBruto.addGainedStuff(oneNewStuff);
        }
    }
}
