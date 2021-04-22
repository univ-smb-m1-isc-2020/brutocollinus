package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchRenderer extends MatchAbstractRenderer {
    public List<AttackRecordRenderer> attackRecords;
    public ArmedBrutoRenderer firstOpponent;
    public ArmedBrutoRenderer secondOpponent;
    public ArmedBrutoRenderer winner;

    public MatchRenderer(Match match) {
        super(match);

        this.attackRecords = match.attackRecords().stream()
                .map(AttackRecordRenderer::new)
                .collect(Collectors.toList());

        this.firstOpponent = new ArmedBrutoRenderer(match.leftChild().selectedBruto());
        this.secondOpponent = new ArmedBrutoRenderer(match.rightChild().selectedBruto());
        this.winner = new ArmedBrutoRenderer(match.selectedBruto());
    }
}
