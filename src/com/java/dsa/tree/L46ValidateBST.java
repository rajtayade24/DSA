package com.java.dsa.tree;

public class L46ValidateBST {

    static boolean selfTry(Node root, long min, long max) {
        if (root == null) return true;

        if (root.data < min || root.data > max) {
            return false;
        }

        return selfTry(root.left, min, root.data)
                && selfTry(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(selfTry(root, Long.MIN_VALUE, Long.MAX_VALUE));
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
