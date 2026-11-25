package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L21TopologicalSort {

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }

        stack.push(node);
    }

    static List<Integer> toposort(List<List<Integer>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = buildDirected();

        System.out.println(toposort(adj));
    }

    static List<List<Integer>> buildDirected() {
        List<List<Integer>> adj = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            adj.add(new LinkedList<>());
        }

        adj.get(2).add(3);

        adj.get(3).add(1);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(0);
        adj.get(5).add(2);

        return adj;
    }
}
