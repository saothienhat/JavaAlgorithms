package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeBinaryTree;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;
import com.vn.utils.TestHelper;

public class SymmetricTree extends LeetCodeTest {

    public SymmetricTree() {
        super("https://leetcode.com/problems/symmetric-tree/description/",
                "Symmetric Tree",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

        // p = [1, 2, 2]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2, 1);
        p.right = new TreeNode(2, 1);;
        //new LeetCodeBinaryTree("P", p).displayAsPreOrder();
        new LeetCodeBinaryTree("P", p).displayAsTree();

        TestHelper.expect(true, isSymmetric(p));

    }

    public boolean isSymmetric(TreeNode root) {


        return false;
    }
}
