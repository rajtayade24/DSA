package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class L12IterativePostorderOptimal {

    static List<Integer> moreOptimal(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node node = root;
        Node lastVisited = null;

        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node peekNode = stack.peek();

                if (peekNode.right != null &&
                        lastVisited != peekNode.right) {

                    node = peekNode.right;
                } else {
                    ans.add(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }

        return ans;
    }

    static List<Integer> optimal(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            ans.add(node.data);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        Node root = Introduction.buildTree();

        List<Integer> ans = optimal(root);

        System.out.println(ans);
    }
}
