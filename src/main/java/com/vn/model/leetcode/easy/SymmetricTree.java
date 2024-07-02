package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeBinaryTree;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;
import com.vn.utils.TestHelper;

import java.util.*;

public class SymmetricTree extends LeetCodeTest {

    public SymmetricTree() {
        super("https://leetcode.com/problems/symmetric-tree/description/",
                "Symmetric Tree",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        // p = [1, 2, 2]
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2, 1);
//        p.right = new TreeNode(2, 1);;
//        //new LeetCodeBinaryTree("P", p).displayAsPreOrder();
//        new LeetCodeBinaryTree("P", p).displayAsTree();

        // p = [1, 2, 3, 4, 5, 6]
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2, 1);
//        p.right = new TreeNode(2, 1);;
//        p.left.left = new TreeNode(3, 2);
//        p.left.right = new TreeNode(4, 2);
//        p.right.left = new TreeNode(5, 2);;
//        //new LeetCodeBinaryTree("P", p).displayAsPreOrder();
//        new LeetCodeBinaryTree("P", p).displayAsTree();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2, 1);
        p.right = new TreeNode(2, 1);;
        p.left.right = new TreeNode(3, 2);
        p.right.left = new TreeNode(3, 2);;
        //new LeetCodeBinaryTree("P", p).displayAsPreOrder();
        new LeetCodeBinaryTree("P", p).displayAsTree();

        TestHelper.expect(true, isSymmetric(p));

    }

    public boolean isSymmetric(TreeNode root) {
        List<List<Integer>> level_list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int treeLevel = queue.size();

            for(int i = 0; i < treeLevel; i++) {
                TreeNode item = queue.poll();
                if(item == null) {
                    values.add(null);
                    continue;
                }
                queue.add(item.left);
                queue.add(item.right);
                values.add(item.val);
            }
            level_list.add(values);
        }

        for(List<Integer> items : level_list) {
            System.out.println(items);
            if(!isPalindrome(items)) return false;
        }
        return true;
    }

    private boolean isPalindrome(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            if(list.get(left) != list.get(right)) return false;
            left += 1;
            right -= 1;
        }
        return true;
    }


}
