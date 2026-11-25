package com.java.dsa.tree;

import java.util.*;

public class L29AllNodesDistanceKInBinaryTree {

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

    static List<Integer> sol(Node root, Node target, int k) {

        Map<Node, Node> parentTrackMap = new HashMap<>();
        markParents(root, parentTrackMap);

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(target, true);

        int dist = 0;

        while (!queue.isEmpty()) {
            if (dist == k) {
                break;
            }
            dist++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }

                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }

                Node parent = parentTrackMap.get(node);
                if (parent != null && !visited.containsKey(parent)) {
                    queue.offer(parent);
                    visited.put(parent, true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.data);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        int k = 2;

        System.out.println(sol(root, root.left, k));
    }
}

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//class Solution {
//    public static void addKDistanceNodes(TreeNode node, int dist, int k, List<Integer> ans) {
//        if (node == null) return;
//
//        if (dist == k) {
//            ans.add(node.val);
//            return;
//        }
//
//        addKDistanceNodes(node.left, dist + 1, k, ans);
//        addKDistanceNodes(node.right, dist + 1, k, ans);
//    }
//
//    public static int dfs(TreeNode node, int k, TreeNode target, List<Integer> ans) {
//        if (node == null) return -1;
//
//        if (node == target) {
//            addKDistanceNodes(node, 0, k, ans);
//
//            return 1;
//        } else {
//            int left = dfs(node.left, k, target, ans);
//            int right = dfs(node.right, k, target, ans);
//
//            if (left == k || right == k) {
//                ans.add(node.val);
//
//                return -1;
//            }
//
//            if (left > 0) {
//                addKDistanceNodes(node.right, left + 1, k, ans);
//                return left + 1;
//            } else if (right > 0) {
//                addKDistanceNodes(node.left, right + 1, k, ans);
//                return right + 1;
//            }
//        }
//
//        return -1;
//    }
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> ans = new ArrayList<>();
//
//        dfs(root, k, target, ans);
//
//        return ans;
//    }
//}