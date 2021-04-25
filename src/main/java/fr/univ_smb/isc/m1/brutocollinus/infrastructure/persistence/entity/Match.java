package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Match extends Node {
    @ManyToOne(cascade = CascadeType.ALL)
    private Node leftChild;
    @ManyToOne(cascade = CascadeType.ALL)
    private Node rightChild;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AttackRecord> attackRecords;

    @ManyToOne
    private ArmedBruto looser;

    public Match() {
        super();

        this.attackRecords = new ArrayList<>();
    }

    public void setChildren(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node rightChild() {
        return this.rightChild;
    }

    public Node leftChild() {
        return this.leftChild;
    }

    public void setWinnerAndLooser(ArmedBruto winner, ArmedBruto looser) {
        this.selectedBruto = winner;
        this.looser = looser;
    }

    public void setAttackRecords(List<AttackRecord> attackRecords) {
        this.attackRecords = attackRecords;
    }

    public List<AttackRecord> attackRecords() {
        return this.attackRecords;
    }

    public ArmedBruto winner() {
        return this.selectedBruto();
    }

    public ArmedBruto looser() {
        return this.looser;
    }
}
