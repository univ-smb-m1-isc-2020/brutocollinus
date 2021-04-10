package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrutoClassRepository extends JpaRepository<BrutoClass, Long> {

    BrutoClass findByName(String name);

}