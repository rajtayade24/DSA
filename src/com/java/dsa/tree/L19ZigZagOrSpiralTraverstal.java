package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L19ZigZagOrSpiralTraverstal {
    
    static List<List<Integer>> selfTry(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean right = false;

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                // Add current node
                list.add(node.data);

                // Always add children left -> right
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            // Reverse alternate levels
            if (right) {
                java.util.Collections.reverse(list);
            }

            ans.add(list);

            right = !right;
        }

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
