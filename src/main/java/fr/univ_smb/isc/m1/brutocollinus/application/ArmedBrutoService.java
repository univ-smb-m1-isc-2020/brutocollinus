package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository.BrutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ArmedBrutoService {
    private final BrutoRepository repository;

    public ArmedBrutoService(BrutoRepository repository) {
        this.repository = repository;
    }

    public ArmedBruto create(Bruto bruto) {
        ArmedBruto armedBruto = new ArmedBruto(bruto);
        this.repository.save(bruto);
        return armedBruto;
    }
}
