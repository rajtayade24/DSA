package com.java.dsa.tree;

public class L40SearchInBST {

    static Node search(Node root, int val) {
        while (root != null) {
            if (root.data == val) {
                return root;
            }

            if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    static Node selfTry(Node root, int val) {
        if (root == null) return null;

        if (root.data == val) {
            return root;
        } else if (root.data < val) {
            return selfTry(root.right, val);
        } else {
            return selfTry(root.left, val);
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int val = 10;

        Node result = selfTry(root, val);

        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("Value not found");
        }
    }

    static Node buildTree() {
        Node root = new Node(8);

        root.left = new Node(5);
        root.right = new Node(12);

        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        return root;
    }
}
