package com.java.dsa.graph;

import java.util.*;

public class L25FindEventualSafeStatesBFS {

    static List<Integer> sol(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> adjRev = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adjRev.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();

            safeNodes.add(node);

            // node is in your topo sort so remove it from the n degree
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println(sol(graph));
    }
}
