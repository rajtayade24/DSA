package com.java.dsa.graph;

import java.util.Arrays;

public class L18BipartiteGraphDFS {

    static boolean dfs(int node, int color, int[] visited, int[][] graph) {

        visited[node] = color;

        for (int neighbor : graph[node]) {
            // Already colored
            if (visited[neighbor] != -1) {

                // Same color -> not bipartite
                if (visited[neighbor] == color)
                    return false;
            } else {

                // Give opposite color
                if (!dfs(neighbor, 1 - color, visited, graph))
                    return false;
            }
        }

        return true;
    }

    static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int start = 0; start < n; start++) {

            // Skip already visited components
            if (visited[start] != -1)
                continue;

            if (!dfs(start, 0, visited, graph))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {0, 2, 5},
                {1, 3},
                {2, 4, 6},
                {3, 5},
                {1, 4},
                {3, 7},
                {6}
        };

        System.out.println(isBipartite(graph));
    }
}