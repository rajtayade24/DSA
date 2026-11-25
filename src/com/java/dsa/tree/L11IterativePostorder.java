package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L11IterativePostorder {

    static List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.add(root);

        while (!st1.isEmpty()) {
            root = st1.pop();

            st2.add(root);

            if (root.left != null) st1.add(root.left);
            if (root.right != null) st1.add(root.right);
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = Introduction.buildTree();

        List<Integer> ans = postorder(root);

        System.out.println(ans);
    }
}
