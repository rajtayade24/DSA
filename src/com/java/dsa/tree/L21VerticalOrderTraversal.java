package com.java.dsa.tree;

import java.util.*;

public class L21VerticalOrderTraversal {

    static class Tuple {
        Node node;
        int row;
        int col;

        Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    static List<List<Integer>> verticalTraversal(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        /*
            1. Column → TreeMap
            2. Row    → TreeMap
            3. Value  → PriorityQueue
        */

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        // root → row 0, column 0
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();

            Node node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            // Create column if not present
            map.putIfAbsent(col, new TreeMap<>());

            // Create row if not present
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Store node value
            map.get(col).get(row).offer(node.data);

            // Left child
            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }

            // Right child
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Convert map into answer
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : rows.values()) {

                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = buildTree();

        System.out.println(verticalTraversal(root));
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