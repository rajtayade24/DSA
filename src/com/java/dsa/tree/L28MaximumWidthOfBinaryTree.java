package com.java.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class L28MaximumWidthOfBinaryTree {

    static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static int selfTry(Node root) {
        if (root == null) return 0;

        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            int size = queue.size();
            int mmin = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();

                Node node = pair.node;
                int curr_ind = pair.index - mmin;

                if (i == 0) first = curr_ind;
                if (i == size - 1) last = curr_ind;

                if (node.left != null)
                    queue.offer(new Pair(node.left, curr_ind * 2 + 1));

                if (node.right != null)
                    queue.offer(new Pair(node.right, curr_ind * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int ans = selfTry(root);
        System.out.println(ans);
    }

    static Node buildTree() {
        Node root = new Node(3);

        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        return root;
    }
}
