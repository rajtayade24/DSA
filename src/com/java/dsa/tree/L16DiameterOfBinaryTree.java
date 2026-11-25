package com.java.dsa.tree;

import static com.java.dsa.tree.L14MaximumDepth.buildTree;

public class L16DiameterOfBinaryTree {

    static int height(Node node, int[] diameter) {

        if (node == null) {
            return 0;
        }

        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);

        // Calculate diameter
        diameter[0] = Math.max(diameter[0], lh + rh);

        // Return height
        return 1 + Math.max(lh, rh);
    }

    static int findDiameter(Node root) {

        int[] diameter = new int[1];

        height(root, diameter);

        return diameter[0];
    }

    public static void main(String[] args) {

        Node root = buildTree();

        System.out.println("Diameter: " + findDiameter(root));
    }
}