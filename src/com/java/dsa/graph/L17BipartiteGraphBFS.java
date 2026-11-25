package com.java.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L17BipartiteGraphBFS {

    static boolean bfs(int start, int[] color, int[][] graph) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                // Already colored
                if (color[neighbor] != -1) {

                    // Adjacent nodes cannot have same color
                    if (color[node] == color[neighbor])
                        return false;

                } else {
                    // Give opposite color
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

    static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            // Skip already visited components
            if (color[start] != -1)
                continue;

            if (!bfs(start, color, graph))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1},          // 0
                {0, 2, 5},       // 1
                {1, 3},    // 2
                {2, 4, 6},       // 3
                {3, 5},    // 4
                {1, 4},       // 5
                {3, 7},       // 6
                {6}           // 7
        };

        System.out.println(isBipartite(graph));
    }
}
