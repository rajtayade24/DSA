package com.java.dsa.tree;

public class L38FlattenBinaryTreeToLinkedList {

    static Node prev = null;

    static void flatten(Node root) {
        prev = null;
        flat(root);
    }

    static void flat(Node root) {
        if (root == null) return;

        flat(root.right);
        flat(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }


    public static void main(String[] args) {
        Node root = buildTree();
        flatten(root);

        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.right.right.right = new Node(7);

        return root;
    }
}
