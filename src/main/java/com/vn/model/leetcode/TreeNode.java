package com.vn.model.leetcode;

public class TreeNode {
    private int level; // level = 0 is root
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        this.level = 0;
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, int level) {
        this.level = level;
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, int level) {
        this.level = level;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getLevel() { return this.level; }
}
