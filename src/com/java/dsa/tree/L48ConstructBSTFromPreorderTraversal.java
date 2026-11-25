package com.java.dsa.tree;

import static com.java.dsa.tree.L9IterativePreorder.preorder;

public class L48ConstructBSTFromPreorderTraversal {

    static Node optimal(int[] preorder) {
        return bstFromPreorder(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    static Node bstFromPreorder(int[] preorder, int[] i, int maxBound) {
        if (i[0] == preorder.length || preorder[i[0]] > maxBound) {
            return null;
        }

        Node root = new Node(preorder[i[0]++]);

        root.left = bstFromPreorder(preorder, i, root.data);
        root.right = bstFromPreorder(preorder, i, maxBound);

        return root;
    }

    static void insert(Node root, int val) {
        Node node = new Node(val);

        while (true) {
            if (val <= root.data) {
                if (root.left == null) {
                    root.left = node;
                    break;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            }
        }
    }

    static Node selfTry(int[] preorder) {

        Node root = new Node(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        Node root = optimal(preorder);

        System.out.println(preorder(root));
    }
}
