package com.java.dsa.tree;

public class LRecoverBinarySearchTree {

    static Node first = null;
    static Node second = null;
    static Node prev = null;

    static void recoverTree(Node root) {
        first = null;
        second = null;
        prev = null;

        inorder(root);

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }


    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.data > root.data) {
            System.out.println("Violation");

            // First violation
            if (first == null) {
                first = prev;
            }

            // Current node is the second wrong node
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = buildTree();

        recoverTree(root);

        System.out.println(L10IterativeInorder.inorder(root));
    }

    static Node buildTree() {
        Node root = new Node(3);

        root.left = new Node(1);
        root.right = new Node(4);

        root.right.left = new Node(2);

        return root;
    }
}
