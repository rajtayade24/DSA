package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class L11DetectCycleInUndirectedGraphUsingDFS {

    static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(1);
        adj.get(1).add(3);

        System.out.println(isCycle(V, adj));
    }
}