package fr.univ_smb.isc.m1.brutocollinus.model.tournament;

import fr.univ_smb.isc.m1.brutocollinus.model.fight.Battle;

public class Match extends Node {
    private Node leftChild;
    private Node rightChild;

    public void resolve() {
        Battle battle = new Battle(this.leftChild.selectedBruto(), this.rightChild.selectedBruto());
        this.selectedBruto = battle.fight();
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
}
