package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.BrutoClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrutoClassRepository extends JpaRepository<BrutoClass, Long> {

    BrutoClass findByName(String name);

    Optional<BrutoClass> findByUuid(String uuid);
}