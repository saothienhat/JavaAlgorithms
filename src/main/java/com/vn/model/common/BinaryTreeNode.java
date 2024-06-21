package com.vn.model.common;


public class BinaryTreeNode<T> {
    private int depth;
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode() {
        this.depth = 0;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T val, int depth) {
        this.depth = depth;
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right, int depth) {
        this.depth = depth;
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public void display() {
        System.out.println("See detail at: BTreePrinter.displayExample()");
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
