package com.java.dsa.tree;

public class L45KthSmallestAndLargestElementInBST {

        static int count;

    static int kthSmallest(Node root, int k) {
        count = 0;
        return inorder(root, k);
    }

    static int inorder(Node root, int k) {
        if (root == null) return -1;

        int left = inorder(root.left, k);

        if (left != -1) return left;

        count++;

        if (count == k) {
            return root.data;
        }

        return inorder(root.right, k);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int k = 3;

        System.out.println(kthSmallest(root, k));
    }

    static Node buildTree() {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(6);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.right = new Node(7);

        return root;
    }
}