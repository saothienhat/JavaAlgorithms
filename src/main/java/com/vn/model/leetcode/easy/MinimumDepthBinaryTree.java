package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;

public class MinimumDepthBinaryTree extends LeetCodeTest {

    public MinimumDepthBinaryTree() {
        super("https://leetcode.com/problems/minimum-depth-of-binary-tree",
                "Minimum Depth of Binary Tree",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {

    }


    private int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;

        int leftH = minDepth(root.left) + 1;
        int rightH = minDepth(root.right) + 1;
        System.out.println("L: " + leftH + " - R: " + rightH);

        return Math.min(leftH, rightH);
    }
}
