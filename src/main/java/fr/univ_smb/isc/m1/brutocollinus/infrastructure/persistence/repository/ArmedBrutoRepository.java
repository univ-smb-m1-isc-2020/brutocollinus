package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Bruto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmedBrutoRepository extends JpaRepository<ArmedBruto, Long> {
    Optional<ArmedBruto> findByUuid(String uuid);

    Optional<ArmedBruto> findByBruto(Bruto bruto);
}