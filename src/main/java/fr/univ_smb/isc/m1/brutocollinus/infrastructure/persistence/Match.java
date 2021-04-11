package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Match extends Node {
    @ManyToOne
    private Node leftChild;
    @ManyToOne
    private Node rightChild;

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
}
