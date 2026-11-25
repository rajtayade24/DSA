package com.java.dsa.tree;

import java.util.*;

public class L24RightSideView {

    static class Tuple {
        Node node;
        int row;

        Tuple(Node node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    static List<Integer> selfTry(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int row = tuple.row;

            map.put(row, node.data);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1));
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
        root.left.left.left = new Node(5);

        return root;
    }
}
