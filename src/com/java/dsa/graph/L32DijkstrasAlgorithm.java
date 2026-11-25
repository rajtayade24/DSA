package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L32DijkstrasAlgorithm {

    static class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    static int[] dijkstra(int V, int[][] edges, int S) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Min-heap based on weight
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.wt, y.wt));

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.wt;

            if (weight > dist[node]) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int newDist = weight + neighbor.wt;

                if (newDist < dist[neighbor.node]) {
                    dist[neighbor.node] = newDist;
                    pq.add(new Pair(neighbor.node, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 3, S = 2;
        int[][] edges = {{0, 1, 1}, {0, 2, 6}, {1, 2, 3}};

//        int V = 2, S = 0;
//        int[][] edges = {{0, 1, 9}};

        int[] ans = dijkstra(V, edges,S);

        System.out.println(Arrays.toString(ans));
    }
}