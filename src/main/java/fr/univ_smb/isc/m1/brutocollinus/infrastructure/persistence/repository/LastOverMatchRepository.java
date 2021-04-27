package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.repository;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.LastOverMatch;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastOverMatchRepository extends JpaRepository<LastOverMatch, Long> {
    void deleteByParticipant(Player participant);

    List<LastOverMatch> findAllByParticipant(Player participant);
}