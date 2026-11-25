package com.java.dsa.tree;

import java.util.List;

public class L49InorderSuccessorAndPredecessorInBST {

    static List<Integer> selfTry(Node root, int key) {
        int p = predecessor(root, key);
        int s = successor(root, key);

        return List.of(p, s);
    }

    static int predecessor(Node root, int key) {
        if (root == null) return -1;

        int ans = -1;

        Node temp = root;
        while (temp != null) {
            if (temp.data < key) {
                ans = temp.data;
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return ans;
    }

    static int successor(Node root, int key) {
        if (root == null) return -1;

        int ans = -1;

        Node temp = root;
        while (temp != null) {
            if (temp.data > key) {
                ans = temp.data;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return ans;
    }

//    static int predecessor(Node root, int key, int[] ans) {
//        if (root == null) return -1;
//
//        predecessor(root.left, key, ans);
//
//        if (root.data < key) {
//            ans[0] = root.data;
//        }
//
//        predecessor(root.right, key, ans);
//
//        return ans[0];
//    }
//
//    static int successor(Node root, int key) {
//        if (root == null) return -1;
//
//        int p = successor(root.left, key);
//        if (p != -1) return p;
//
//        if (root.data > key) {
//            return root.data;
//        }
//
//        return successor(root.right, key);
//    }

    public static void main(String[] args) {
        Node root = buildTree();

        int key = 10;

        List<Integer> ans = selfTry(root, key);

        System.out.println("Ans: " + ans);
    }

    static Node buildTree() {
        Node root = new Node(5);

        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(12);

        return root;
    }
}
