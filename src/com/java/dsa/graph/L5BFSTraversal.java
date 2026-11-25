package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L5BFSTraversal {

    static List<Integer> bfsTraversal(int v, List<List<Integer>> adj) {

        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);

            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {

        List<List<Integer>> adj = buildGraph();

        // Access graph here
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        System.out.println("BFS Traversal of graph");
        System.out.println(bfsTraversal(adj.size(), adj));
    }

    static List<List<Integer>> buildGraph() {

        int n = 9;

        List<List<Integer>> adj = new ArrayList<>();

        // Create empty list for each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(5);
        adj.get(5).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(7);
        adj.get(7).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(5).add(8);
        adj.get(8).add(5);

        adj.get(6).add(7);
        adj.get(7).add(6);

        return adj;
    }
}