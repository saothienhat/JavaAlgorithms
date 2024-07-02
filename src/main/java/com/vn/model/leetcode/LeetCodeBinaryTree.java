package com.vn.model.leetcode;

import com.vn.model.common.AppConst;
import com.vn.model.common.BinaryTreeNode;

import java.util.*;

public class LeetCodeBinaryTree {
    private TreeNode root;
    private String name;

    public LeetCodeBinaryTree(TreeNode node) {
        this.root = node;
        this.name = "LeetCode Binary Tree";
    }

    public LeetCodeBinaryTree(String name, TreeNode node) {
        this.root = node;
        this.name = name;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void displayAsPreOrder() {
        System.out.println("Perform pre-order traversal: that first visits the root node, then left subtree, and finally the right subtree.");
        System.out.println("Tree name: " + this.name);
        final String treeStr = traversePreOrder();
        System.out.println(treeStr);
    }

    /**
     * Ref: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
     */
    public void displayAsTree() {
        System.out.println("Display as Binary Tree for: " + this.getName() + AppConst.NEW_LINE);
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        System.out.println(AppConst.NEW_LINE);
    }


    private String traversePreOrder() {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodesAsPreOrder(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodesAsPreOrder(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    /**
     * Ref: https://www.baeldung.com/java-print-binary-tree-diagram
     */
    private void traverseNodesAsPreOrder(StringBuilder sb, String padding, String pointer, TreeNode node,
                                         boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodesAsPreOrder(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodesAsPreOrder(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }


    private int maxLevel(TreeNode node) {
        return (node == null) ? 0 : Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    /**
     * Ref: https://www.geeksforgeeks.org/level-order-tree-traversal/
     * Get the height of Tree
     */
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            // Compute  height of each subtree
            int lheight = height(node.left);
            int rheight = height(node.right);

            // use the larger one
            return (lheight > rheight) ? (lheight + 1) : (rheight + 1);
        }
    }

    public Optional<TreeNode> breadthFirstSearch(TreeNode node, int value) {
        if(node == null) return Optional.empty();

        List<List<Integer>> level_list = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int treeLevel = queue.size();

            TreeNode currNode = queue.poll();
            for(int i = 0; i < treeLevel; i++) {
                if(currNode == null) {
                    values.add(null);
                    continue;
                }

                if(currNode.val == value) {
                    // return Optional.of(currNode); // Should return here
                } else {
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                    values.add(currNode.val);
                }
            }
            level_list.add(values);
        }

        System.out.println("Values via Tree Level:");
        for(List<Integer> items : level_list) {
            // Print values via Tree Level
            System.out.println(items);
            if(items.contains(value)) return Optional.of(new TreeNode(value));
        }

        return Optional.empty();
    }

    /**
     *  Depth First Search or DFS
        Ref: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
         Inorder(tree)

         Traverse the left subtree, i.e., call Inorder(left->subtree)
         Visit the root.
         Traverse the right subtree, i.e., call Inorder(right->subtree)
     */
    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(TreeNode node) {
        if(node == null) return;

        // First recur on left child
        printInOrder(node.left);

        // Then print the data of node
        System.out.print(node.val + " ");

        // Now recur on right child
        printInOrder(node.right);
    }

    /**
     *  Depth First Search or DFS
     Ref: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
     Preorder(tree)

     +  Visit the root.
     + Traverse the left subtree, i.e., call Preorder(left->subtree)
     + Traverse the right subtree, i.e., call Preorder(right->subtree)
     */
    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(TreeNode node) {
        if(node == null) return;
        // First print data of node
        System.out.print(node.val + " ");

        // Then recur on left subtree
        printPreOrder(node.left);

        // Now recur on right subtree
        printPreOrder(node.right);
    }

    /**
     *  Depth First Search or DFS
     Ref: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
     Postorder(tree)

     Traverse the left subtree, i.e., call Postorder(left->subtree)
     Traverse the right subtree, i.e., call Postorder(right->subtree)
     Visit the root
     */
    public void printPostOrder() {
        printPostOrder(root);
    }
    private void printPostOrder(TreeNode node) {
        if (node == null)
            return;

        // First recur on left subtree
        printPostOrder(node.left);

        // Then recur on right subtree
        printPostOrder(node.right);

        // Now deal with the node
        System.out.print(node.val + " ");
    }

    public void addRight(int value) {
        addRight(root, value);
    }

    public void addLeft(int value) {
        addLeft(root, value);
    }

    public void addRight(TreeNode node, int value) {
        if(node != null) {
            node.right = new TreeNode(value);
            System.out.println("Added new node at RIGHT");
        } else {
            System.out.println("Node is null to add child");
        }
    }

    public void addLeft(TreeNode node, int value) {
        if(node != null) {
            node.left = new TreeNode(value);
            System.out.println("Added new node at LEFT");
        } else {
            System.out.println("Node is null to add child");
        }
    }


}
