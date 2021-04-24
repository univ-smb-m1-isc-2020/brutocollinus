package fr.univ_smb.isc.m1.brutocollinus.utils.renderer;

import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.ArmedBruto;
import fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity.Match;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchRenderer extends MatchAbstractRenderer {
    public List<AttackRecordRenderer> attackRecords;
    public ArmedBrutoRenderer firstOpponent;
    public ArmedBrutoRenderer secondOpponent;
    public ArmedBrutoRenderer winner;
    public ArmedBrutoRenderer looser;

    public MatchRenderer(Match match) {
        super(match);

        this.attackRecords = match.attackRecords().stream()
                .map(AttackRecordRenderer::new)
                .collect(Collectors.toList());

        ArmedBruto leftChildSelectedBruto = match.leftChild().selectedBruto();
        if (leftChildSelectedBruto != null) {
            this.firstOpponent = new ArmedBrutoRenderer(leftChildSelectedBruto);
        }

        ArmedBruto rightChildSelectedBruto = match.rightChild().selectedBruto();
        if (rightChildSelectedBruto != null) {
            this.secondOpponent = new ArmedBrutoRenderer(rightChildSelectedBruto);
        }

        ArmedBruto winner = match.winner();
        if (winner != null) {
            this.winner = new ArmedBrutoRenderer(winner);
        }

        ArmedBruto looser = match.looser();
        if (looser != null) {
            this.winner = new ArmedBrutoRenderer(looser);
        }
    }
}
