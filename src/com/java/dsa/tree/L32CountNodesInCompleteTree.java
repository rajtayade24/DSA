package com.java.dsa.tree;

public class L32CountNodesInCompleteTree {

    static int countNodes(Node root) {
        if (root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

//      For a perfect binary tree, Number of nodes: 2³ - 1 = 7
        if (lh == rh)
            return (1 << lh) - 1; // 2^lh - 1

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int leftHeight(Node root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    static int rightHeight(Node root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(countNodes(root));
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        return root;
    }
}