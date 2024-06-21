package com.vn.model.leetcode;

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

    public void displayAsPreOrder() {
        System.out.println("Perform pre-order traversal: that first visits the root node, then left subtree, and finally the right subtree.");
        System.out.println("Tree name: " + this.name);
        final String treeStr = traversePreOrder();
        System.out.println(treeStr);
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
}
