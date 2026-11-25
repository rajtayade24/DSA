package com.java.dsa.tree;

import java.util.List;

public class L41FloorAndCeiInBST {

    static List<Integer> selfTry(Node root, int val) {
        return List.of(floorValue(root, val), ceilValue(root, val));
    }

    static int floorValue(Node root, int val) {
        int ans = -1;
        while (root != null) {
            if (root.data <= val) {
                ans = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans;
    }

    static int ceilValue(Node root, int val) {
        int ans = -1;
        while (root != null) {
            if (root.data >= val) {
                ans = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int key = 11;

        System.out.println(selfTry(root, key));
    }

    static Node buildTree() {
        Node root = new Node(8);

        root.left = new Node(5);
        root.right = new Node(12);

        root.left.left = new Node(4);
        root.left.right = new Node(7);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        return root;
    }
}
