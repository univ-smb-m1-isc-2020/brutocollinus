package fr.univ_smb.isc.m1.brutocollinus.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
public class Match extends Node {
    @ManyToOne(cascade = CascadeType.ALL)
    private Node leftChild;
    @ManyToOne(cascade = CascadeType.ALL)
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
