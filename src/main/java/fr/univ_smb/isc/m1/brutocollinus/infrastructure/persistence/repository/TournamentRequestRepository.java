package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.TournamentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRequestRepository extends JpaRepository<TournamentRequest, Long> {
    Optional<TournamentRequest> findById(Long id);
}