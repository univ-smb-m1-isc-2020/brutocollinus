package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuffRepository extends JpaRepository<Stuff, Long> {

    Stuff findByName(String name);

    List<Stuff> findByUuidIn(List<String> uuids);
}