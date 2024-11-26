package com.vn.model.common;


import com.vn.model.leetcode.TreeNode;

import java.util.*;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private String name;

    public BinaryTree(BinaryTreeNode<T> node) {
        this.root = node;
        this.name = "Binary Tree";
    }

    public BinaryTree(String name, BinaryTreeNode<T> node) {
        this.root = node;
        this.name = name;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ref: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
     */
    public void displayAsTree(BinaryTreeNode<T> root) {
        System.out.println("Display as Binary Tree for: " + this.getName() + AppConst.NEW_LINE);
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        System.out.println(AppConst.NEW_LINE);
    }

    /**
     * Ref: https://www.baeldung.com/java-print-binary-tree-diagram
     */
    public void displayAsPreOrder() {
        System.out.println("Perform pre-order traversal: that first visits the root node, then left subtree, and finally the right subtree.");
        System.out.println("Tree name: " + this.name + AppConst.NEW_LINE);
        final String treeStr = traversePreOrder();
        System.out.println(treeStr);
        System.out.println(AppConst.NEW_LINE);
    }

    public String traversePreOrder() {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodesAsPreOrder(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodesAsPreOrder(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    public void breadthFirstSearch() {

    }

    // Function to print level order traversal of tree
    private void printLevelOrder() {
        int h = height(root);
        for (int i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
    // Print nodes at the current level
    private void printCurrentLevel(BinaryTreeNode<T> root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getValue() + " ");
        else if (level > 1) {
            printCurrentLevel(root.getLeft(), level - 1);
            printCurrentLevel(root.getRight(), level - 1);
        }
    }

    /**
     * Ref: https://www.geeksforgeeks.org/level-order-tree-traversal/
     * Get the height of Tree
     */
    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
        else {
            // Compute  height of each subtree
            int lheight = height(node.getLeft());
            int rheight = height(node.getRight());

            // use the larger one
//            return (lheight > rheight) ? (lheight + 1) : (rheight + 1);
            return Math.max(lheight,rheight) + 1;
        }
    }

    /**
     * Ref: https://www.baeldung.com/java-print-binary-tree-diagram
     */
    private void traverseNodesAsPreOrder(StringBuilder sb, String padding, String pointer, BinaryTreeNode<T> node,
                                         boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodesAsPreOrder(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodesAsPreOrder(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }



    private void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newNodes = new ArrayList<BinaryTreeNode<T>>();
        for (BinaryTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
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

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
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

    private int maxLevel(BinaryTreeNode<T> node) {
        return (node == null) ? 0 : Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List<BinaryTreeNode<T>> list) {
        for (BinaryTreeNode<T> object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    public Optional<BinaryTreeNode<T>> breadthFirstSearch(BinaryTreeNode<T> node, T value) {
        if(node == null) return Optional.empty();

        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            BinaryTreeNode<T> currNode = queue.poll();
            if(currNode == null) {
                continue;
            }

            if(currNode.getValue() == value) {
                return Optional.of(currNode);
            } else {
                queue.add(currNode.getLeft());
                queue.add(currNode.getRight());
            }
        }
        return Optional.empty();
    }

    /*
    Depth First Traversals
        Inorder Traversal (Left-Root-Right)
        Preorder Traversal (Root-Left-Right)
        Postorder Traversal (Left-Right-Root)
     */
}
