package com.java.dsa.tree;

public class L14MaximumDepth {

    static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(maxDepth(root));
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(6);

        root.right.left.left = new Node(5);

        return root;
    }
}