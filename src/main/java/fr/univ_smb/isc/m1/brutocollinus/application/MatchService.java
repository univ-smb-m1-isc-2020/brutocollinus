package fr.univ_smb.isc.m1.brutocollinus.application;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    public void process(Match match) {
        match.setSelectedBruto(match.leftChild().selectedBruto());
    }
}
