package com.java.dsa.tree;

public class L43InsertIntoBST {

    static Node insert(Node root, int val) {
        Node newNode = new Node(val);

        if (root == null) return newNode;

        Node temp = root;

        while (true) {
            if (val < temp.data) {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int key = 5;

        System.out.println(insert(root, key).data);
    }

    static Node buildTree() {
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        return root;
    }
}