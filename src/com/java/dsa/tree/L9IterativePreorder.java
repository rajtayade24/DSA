package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L9IterativePreorder {

    static List<Integer> preorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            stack.pop();

            ans.add(node.data);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

        }
        return ans;
    }

    public static void main(String[] args) {

        Node root = Introduction.buildTree();

        preorder(root);

    }
}
