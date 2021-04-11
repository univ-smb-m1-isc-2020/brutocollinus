package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}