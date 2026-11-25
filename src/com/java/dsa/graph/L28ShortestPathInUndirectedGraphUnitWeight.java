package com.java.dsa.graph;

import java.util.*;

public class L28ShortestPathInUndirectedGraphUnitWeight {

    public int[] selfTry(int[][] edges, int N, int M) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {

                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = 1 + dist[node];
                    q.offer(neighbor);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

    }
}
