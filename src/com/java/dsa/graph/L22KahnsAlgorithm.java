package com.java.dsa.graph;

import java.util.*;

public class L22KahnsAlgorithm {

    static List<Integer> sort(List<List<Integer>> adj) {
        int n = adj.size();

        int[] indegree = new int[n];
        for (List<Integer> list : adj) {
            for (int node : list) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topo=new ArrayList<>();

        //O(V+E)
        while (!queue.isEmpty()) {
            int node= queue.poll();

            topo.add(node);

            // node is in your topo sort so remove it from the n degree
            for(int neighbor: adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor]==0)
                    queue.offer(neighbor);
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = buildDirected();
        System.out.println(sort(adj));
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
