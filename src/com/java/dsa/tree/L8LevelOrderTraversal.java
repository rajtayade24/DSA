package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L8LevelOrderTraversal {

    //          1
    //        /   \
    //       2     3
    //      / \   / \
    //     4   5 6   7

    public List<List<Integer>> levelOrderUsingRecursion(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    void dfs(Node root, int lvl, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (ans.size() <= lvl) {
            ans.add(new ArrayList<>());
        }

        ans.get(lvl).add(root.data);

        dfs(root.left, lvl + 1, ans);
        dfs(root.right, lvl + 1, ans);
    }

    static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            int size = queue.size(); // store current level size

            for (int i = 0; i < size; i++) {
                Node node = queue.peek();
                queue.poll();

                level.add(node.data);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(level);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("\nLevel order traversal: ");
        System.out.println(levelOrder(root));
    }
}
