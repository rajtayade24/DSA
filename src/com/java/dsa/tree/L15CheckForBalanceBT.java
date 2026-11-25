package com.java.dsa.tree;

import static com.java.dsa.tree.L14MaximumDepth.maxDepth;

public class L15CheckForBalanceBT {

    static int optimal(Node root) {
        if (root == null) return 0;

        int lh = optimal(root.left);
        int rh = optimal(root.right);

        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh) + 1;
    }

    static boolean checkOptimal(Node root) {
        return optimal(root) != -1;
    }


    static boolean check(Node root) {
        if (root == null) return true;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        boolean left = check(root.left);
        boolean right = check(root.right);

        return left && right;
    }

    public static void main(String[] args) {
        Node root = buildTree();

        System.out.println(check(root));
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(6);

        root.right.left.left = new Node(5);

        return root;
    }
}
