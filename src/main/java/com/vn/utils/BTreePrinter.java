package com.vn.utils;

import com.vn.model.common.BinaryTreeNode;
import com.vn.model.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {
    public static <T extends Comparable<?>> void displayTree(BinaryTreeNode<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newNodes = new ArrayList<BinaryTreeNode<T>>();
        for (BinaryTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    /**
     * How to use
     */
    private static void displayExample() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> n11 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> n12 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n21 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> n22 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> n23 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> n24 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> n31 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n32 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> n33 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> n34 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n35 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> n36 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> n37 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> n38 = new BinaryTreeNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        displayTree(root);
    }
}
