package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;

public class BalancedBinaryTree extends LeetCodeTest {

    public BalancedBinaryTree() {
        super("https://leetcode.com/problems/balanced-binary-tree",
                "Balanced Binary Tree",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        System.out.println("Left: " + heightLeft + " - Right: " + heightRight);
        if (heightRight - heightLeft > 1 || heightLeft - heightRight > 1
                || (heightLeft == heightRight && heightLeft > 1)
        ) return false;

        return true;
    }


    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int result = (leftHeight > rightHeight) ? (leftHeight - rightHeight) : (rightHeight - leftHeight);
        return result;
    }

    private int heightLeft(TreeNode root) {
        if (root == null) return 0;
        int height = heightLeft(root.left);
        return height + 1;
    }

    private int heightRight(TreeNode root) {
        if (root == null) return 0;
        int height = heightRight(root.right);
        return height + 1;
    }

}
