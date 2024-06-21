package com.vn.model.leetcode;

import java.io.PrintStream;

public class TreeNode {
    private int depth; // level = 0 is root
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        this.depth = 0;
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
        this.depth = level;
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, int level) {
        this.depth = level;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getLevel() { return this.depth; }

    private void traversePreOrder(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append(node.val);
            // sb.append("\n");
            sb.append(" ");
            traversePreOrder(sb, node.left);
            traversePreOrder(sb, node.right);
        }
    }

    public String displayAsString() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, this);
        final String result = sb.toString();
        System.out.println("[INFO] displayAsString: " + result);
        return result;
    }
}
