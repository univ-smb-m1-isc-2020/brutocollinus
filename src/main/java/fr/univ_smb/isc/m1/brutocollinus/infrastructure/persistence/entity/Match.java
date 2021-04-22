package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Match extends Node {
    @ManyToOne(cascade = CascadeType.ALL)
    private Node leftChild;
    @ManyToOne(cascade = CascadeType.ALL)
    private Node rightChild;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AttackRecord> attackRecords;

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

    public void setSelectedBruto(ArmedBruto selectedBruto) {
        this.selectedBruto = selectedBruto;
    }

    public void setAttackRecords(List<AttackRecord> attackRecords) {
        this.attackRecords = attackRecords;
    }

    public List<AttackRecord> attackRecords() {
        return this.attackRecords;
    }
}
