package com.java.dsa.tree;

import java.util.*;

public class RootToLeafPath {

    static List<List<Integer>> leafPath(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        List<Integer> path = new ArrayList<>();
        dfs(root, path, ans);

        return ans;
    }

    static void dfs(Node node, List<Integer> path, List<List<Integer>> ans) {
        // Add current node to path
        path.add(node.data);

        // If leaf, store the complete path
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }

        // Go left
        if (node.left != null) {
            dfs(node.left, path, ans);
        }

        // Go right
        if (node.right != null) {
            dfs(node.right, path, ans);
        }

        // Backtrack
        path.removeLast();
    }

    static List<List<Integer>> selfTry(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(List.of(root));

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                List<Node> list = queue.poll();

                Node lastNode = list.getLast();

                if (lastNode.left == null && lastNode.right == null) {
                    List<Integer> path = new ArrayList<>();

                    for (Node node : list) {
                        path.add(node.data);
                    }
                    ans.add(path);
                }

                // Add left path
                if (lastNode.left != null) {
                    List<Node> temp = new ArrayList<>(list);
                    temp.add(lastNode.left);
                    queue.offer(temp);
                }

                // Add right path
                if (lastNode.right != null) {
                    List<Node> temp = new ArrayList<>(list);
                    temp.add(lastNode.right);
                    queue.offer(temp);
                }
            }
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
