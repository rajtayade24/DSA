package com.java.dsa.tree;

public class L17MaximumPathSum {

    static int height(Node node, int[] path) {
        if (node == null) return 0;

        // If leaf node is negative then it will store 0
        int maxL = Math.max(0, height(node.left, path));
        int maxR = Math.max(0, height(node.right, path));

        // Calculate path
        path[0] = Math.max(path[0], maxL + maxR + node.data);

        // Return path
        return node.data + Math.max(maxL, maxR);
    }

    static int findPath(Node root) {
        int[] path = new int[1];

        path[0] = Integer.MIN_VALUE;

        height(root, path);

        return path[0];
    }

    public static void main(String[] args) {

        Node root = buildTree();

        System.out.println("Diameter: " + findPath(root));
    }

    static Node buildTree() {
        Node root = new Node(-10);

        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        return root;
    }
}
