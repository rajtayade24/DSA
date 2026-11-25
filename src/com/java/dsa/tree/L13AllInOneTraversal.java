package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L13AllInOneTraversal {

    static class Pair {
        Node node;
        int num;

        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    static List<List<Integer>> solution(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            // This part is of pre
            // increment 1 to 2
            // push left into the stack
            if (pair.num == 1) {
                pre.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if (pair.node.left != null)
                    stack.push(new Pair(pair.node.left, 1));
            }

            // This part is of in
            // increment 2 to 3
            // push right into the stack
            else if (pair.num == 2) {
                in.add(pair.node.data);
                pair.num++;
                stack.push(pair);

                if (pair.node.right != null)
                    stack.push(new Pair(pair.node.right, 1));
            }

            // Don;t push it back again
            else {
                post.add(pair.node.data);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(in);
        ans.add(post);

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();

        List<List<Integer>> ans = solution(root);

        for (List<Integer> list : ans)
            System.out.println(list);
    }

    static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;
    }
}
