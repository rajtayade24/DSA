package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L6DFSTraversal {

    static List<Integer> traversal(int v, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[v];

        rec(0, visited, dfs, adj);

        return dfs;
    }

    static void rec(int node, boolean[] visited, List<Integer> dfs, List<List<Integer>> adj) {
        visited[node] = true;
        dfs.add(node);

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                rec(it, visited, dfs, adj);
            }
        }
    }

    static List<Integer> dfsTraversal(int v, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (visited[node]) continue;

            visited[node] = true;
            dfs.add(node);

            for (int i = adj.get(node).size() - 1; i >= 0; i--) {
                int neighbor = adj.get(node).get(i);

                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        return dfs;
    }

    static List<Integer> selfTry(int v, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        visited[0] = true;
        dfs.add(0);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            boolean flag = false;

            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    stack.push(it);
                    dfs.add(it);
                    visited[it] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                stack.pop();
            }
        }

        return dfs;
    }

    public static void main(String[] args) {

        List<List<Integer>> adj = Introduction.buildGraph();

        // Access graph here
        for (int i = 1; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        System.out.println("DFS Traversal of graph");
        System.out.println(dfsTraversal(adj.size(), adj));

        System.out.println("DFS Traversal of graph, recursive approach");
        System.out.println(traversal(adj.size(), adj));
    }

}
