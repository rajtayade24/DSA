package com.java.dsa.graph;

import java.util.*;

public class L27ShortestPathInDAG {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static List<List<Pair>> toAdjList(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        return adj;
    }

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {

        visited[node] = true;

        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.node]) {
                dfs(neighbor.node, visited, stack, adj);
            }
        }

        stack.push(node);
    }

    static Stack<Integer> toposort(List<List<Pair>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        return stack;
    }

    static int[] sol(int n, int m, int[][] edges) {
        List<List<Pair>> adj = toAdjList(n, m, edges);

        Stack<Integer> sortSt = toposort(adj);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0; // Source node

        while (!sortSt.isEmpty()) {
            int node = sortSt.pop();

            if (dist[node] == Integer.MAX_VALUE) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int val = neighbor.node;
                int wt = neighbor.weight;

                if (dist[val] > dist[node] + wt) {
                    dist[val] = dist[node] + wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        int N = 6, M = 7;

        System.out.println(Arrays.toString(sol(N, M, edges)));
    }
}