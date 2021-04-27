package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.BrutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrutoService {
    private final BrutoRepository repository;

    public BrutoService(BrutoRepository repository) {
        this.repository = repository;
    }

    public Bruto create(String name, BrutoClass brutoClass, Player owner) {
        Bruto bruto = new Bruto(name, brutoClass, owner);
        this.repository.save(bruto);
        owner.addBruto(bruto);
        return bruto;
    }

    public Bruto get(String uuid) {
        return this.repository.findByUuid(uuid).orElse(null);
    }
}
