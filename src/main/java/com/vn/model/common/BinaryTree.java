package com.vn.model.common;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
