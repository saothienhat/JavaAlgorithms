package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeBinaryTree;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderPreorderPostorderTraversal extends LeetCodeTest {

    public BinaryTreeInorderPreorderPostorderTraversal() {
        super("https://leetcode.com/problems/binary-tree-inorder-traversal or https://leetcode.com/problems/binary-tree-preorder-traversal/description/",
                "Binary Tree Inorder/Preorder Traversal",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

        final int LEVEL_1 = 1;
        final int LEVEL_2 = 2;

        // root = [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode rightNode = new TreeNode(2, LEVEL_1);
        rightNode.left = new TreeNode(3, LEVEL_2);
        rightNode.right = null;
        root.right = rightNode;

//        List<Integer> list = inorderTraversal(root);
//        System.out.println(list);

//        root.displayAsString();

        LeetCodeBinaryTree tree = new LeetCodeBinaryTree(root);
        tree.displayAsPreOrder();
        System.out.println("Tree Height: " + tree.height());

    }


    // Hint: https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/5295399/easy-stack-solution-python-java/
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(true) {
            if(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                currNode = stack.pop();
                list.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return list;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currNode = root;

        while(true) {
            if(currNode != null) {
                nodeStack.push(currNode);
                list.add(currNode.val);
                currNode = currNode.left;
            } else {
                if(nodeStack.isEmpty()) {
                    break;
                }
                currNode = nodeStack.pop();
                currNode = currNode.right;
            }
        }

        return list;
    }



    List<Integer> postorderTraversalList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return postorderTraversalList;
    }

    private void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            postorderTraversalList.add(root.val);
        }
    }


}
