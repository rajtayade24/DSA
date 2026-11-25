package com.java.dsa.graph;

import java.util.LinkedList;
import java.util.List;

public class L19DetectCycleInDirectedGraphUsingDFS {

    static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, pathVisited, adj)) {
                    return true;
                }
                // If both visited and pathVisited -> cycle
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        // All neighbors are checked; remove this node from the current DFS path
        pathVisited[node] = false;
        return false;
    }

    static boolean isDirected(List<List<Integer>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = buildDirected();

        System.out.println(isDirected(adj));
    }

    static List<List<Integer>> buildDirected() {
        List<List<Integer>> adj = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            adj.add(new LinkedList<>());
        }

        adj.getFirst().add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(3);
        adj.get(2).add(6);

        adj.get(3).add(4);

        adj.get(4).add(5);

        adj.get(6).add(4);

        adj.get(7).add(1);
        adj.get(7).add(8);

        adj.get(8).add(9);

        adj.get(9).add(7);

        return adj;
    }
}
