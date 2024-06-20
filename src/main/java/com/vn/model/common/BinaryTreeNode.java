package com.vn.model.common;


public class BinaryTreeNode<T> {
    private int depth;
    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

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
}
