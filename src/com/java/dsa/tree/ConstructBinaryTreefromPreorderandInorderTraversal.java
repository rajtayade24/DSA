package com.java.dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, preorder.length - 1,
                0, inorder.length - 1,
                inMap);

        return root;
    }

    private static Node buildTree(
            int[] preorder,
            int preStart,
            int preEnd,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preorder[preStart]);

        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(
                preorder,
                preStart + 1,
                preStart + numsLeft,
                inStart,
                inRoot - 1,
                inMap
        );

        root.right = buildTree(
                preorder,
                preStart + numsLeft + 1,
                preEnd,
                inRoot + 1,
                inEnd,
                inMap
        );

        return root;
    }

    public static void main(String[] args) {

    }
}