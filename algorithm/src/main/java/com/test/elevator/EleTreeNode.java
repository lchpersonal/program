package com.test.elevator;

/**
 * Created by chengli on 2016/11/7.
 */
public class EleTreeNode {
    private int deep;
    private int people;
    private EleTreeNode left;
    private EleTreeNode right;

    public EleTreeNode(int deep, int people) {
        this.deep = deep;
        this.people = people;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public EleTreeNode getLeft() {
        return left;
    }

    public void setLeft(EleTreeNode left) {
        this.left = left;
    }

    public EleTreeNode getRight() {
        return right;
    }

    public void setRight(EleTreeNode right) {
        this.right = right;
    }
}
