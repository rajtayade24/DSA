package com.java.dsa.tree;

import java.util.*;

public class L23BottomView {

    static class Tuple {
        Node node;
        int col;

        Tuple(Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    static List<Integer> selfTry(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        /*
            1. Column → Integer
            2. Value  → Integer
        */

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            Node node = tuple.node;
            int col = tuple.col;

            map.put(col, node.data);

            // Left child
            if (node.left != null) {
                queue.offer(new Tuple(node.left, col - 1));
            }

            // Right child
            if (node.right != null) {
                queue.offer(new Tuple(node.right, col + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();

        System.out.println(selfTry(root));
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
