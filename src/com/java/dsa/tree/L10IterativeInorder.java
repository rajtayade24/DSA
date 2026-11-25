package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L10IterativeInorder {

    static List<Integer> inorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node node = root;

        while (node != null || !stack.isEmpty()) {

            // Go to the leftmost node
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Process the node
            node = stack.pop();
            ans.add(node.data);

            // Move to right subtree
            node = node.right;
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = Introduction.buildTree();

        List<Integer> ans = inorder(root);

        System.out.println(ans);
    }
}
