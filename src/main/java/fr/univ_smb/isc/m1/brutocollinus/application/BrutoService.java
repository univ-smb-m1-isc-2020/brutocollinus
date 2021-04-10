package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.*;
import org.springframework.stereotype.Service;

@Service
public class BrutoService {
    private final BrutoRepository repository;

    public BrutoService(BrutoRepository repository) {
        this.repository = repository;
    }

    public Bruto create(String name, BrutoClass brutoClass, Player owner) {
        Bruto bruto = new Bruto(name, brutoClass, owner);
        this.repository.save(bruto);
        return bruto;
    }
}
