package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class L20BoundaryTraversal {

    static void leftBoundary(Node root, List<Integer> ans) {
        if (root == null) return;

        // Don't add leaf nodes here
        if (root.left == null && root.right == null)
            return;

        ans.add(root.data);

        if (root.left != null) leftBoundary(root.left, ans);
        else leftBoundary(root.right, ans);
    }

    static void leafNodes(Node root, List<Integer> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    static void rightBoundary(Node root, List<Integer> ans) {
        if (root == null) return;

        // Don't add leaf nodes here
        if (root.left == null && root.right == null)
            return;

        if (root.right != null)
            rightBoundary(root.right, ans);
        else
            rightBoundary(root.left, ans);

        // Add while coming back
        ans.add(root.data);
    }

    static List<Integer> solution(Node root, List<Integer> ans) {
        if (root == null)
            return ans;

        leftBoundary(root, ans);
        leafNodes(root, ans);
        rightBoundary(root, ans);

        ans.removeLast();

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();

        List<Integer> ans = new ArrayList<>();

        System.out.println(solution(root, ans));
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.left = new Node(6);
        root.left.left.right.right = new Node(7);

        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        return root;
    }
//
//    static Node buildTree() {
//        Node root = new Node(1);
//
//        root.left = new Node(2);
//        root.right = new Node(3);
//
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//
//        root.left.right.left = new Node(8);
//        root.left.right.right = new Node(9);
//
//
//        return root;
//    }

}
