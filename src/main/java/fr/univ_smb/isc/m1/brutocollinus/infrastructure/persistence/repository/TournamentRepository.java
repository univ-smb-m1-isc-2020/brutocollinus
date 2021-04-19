package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Optional<Tournament> findById(Long id);

    List<Tournament> findAllByState(Tournament.State state);
}