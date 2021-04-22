package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.RenderedMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RenderedMatchRepository extends JpaRepository<RenderedMatch, Long> {
    void deleteByMatch(Match match);

    Optional<RenderedMatch> findByMatch(Match match);
}