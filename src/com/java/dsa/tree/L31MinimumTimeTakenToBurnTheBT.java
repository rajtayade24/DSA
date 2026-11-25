package com.java.dsa.tree;

import java.util.*;

public class L31MinimumTimeTakenToBurnTheBT {

    static void markParents(Node root, Map<Node, Node> parentTrackMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                parentTrackMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentTrackMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    static int selfTry(Node root, Node target) {

        Map<Node, Node> parentTrackMap = new HashMap<>();
        markParents(root, parentTrackMap);

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(target, true);

        int time = 0;

        while (!queue.isEmpty()) {

            boolean burned = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                    burned = true;
                }

                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                    burned = true;
                }

                Node parent = parentTrackMap.get(node);
                if (parent != null && !visited.containsKey(parent)) {
                    queue.offer(parent);
                    visited.put(parent, true);
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.left.right = new Node(7);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println(selfTry(root, root.right));
    }

}
