package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.common.BinaryTreeNode;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;
import com.vn.utils.BTreePrinter;
import com.vn.utils.TestHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SameTree extends LeetCodeTest {

    public SameTree() {
        super("https://leetcode.com/problems/same-tree/",
                "Same Tree",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();
        final int LEVEL_1 = 1;
        final int LEVEL_2 = 2;

        // p = [1, 2, 3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2, LEVEL_1);
        p.right = null;
        new TreeNode(3, LEVEL_1);
//        System.out.println("[INFO] displayAsString: " + p.displayAsString());

        // q = [1, 2, 3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2, LEVEL_1);
        q.right = null;
        new TreeNode(3, LEVEL_1);

        TestHelper.expect(true, isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode currNode = p;
        TreeNode currNode1 = q;
        while (true) {
            if ((currNode == null && currNode1 != null)
                    || (currNode != null && currNode1 == null)
            ) {
                return false;
            }
            if (currNode != null && currNode1 != null) {
                stack.push(currNode);
                stack1.push(currNode1);
                currNode = currNode.left;
                currNode1 = currNode1.left;
            } else {
                if (stack.isEmpty() || stack1.isEmpty()) {
                    break;
                }
                currNode = stack.pop();
                currNode1 = stack1.pop();
                if (currNode != null && currNode1 != null && currNode1.val != currNode.val) {
                    return false;
                }
                currNode = currNode.right;
                currNode1 = currNode1.right;
            }
        }
        return true;
    }

}
