package com.java.dsa.graph;

import java.util.*;

public class L11DetectCycleInUndirectedGraphUsingBFS {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {

            if (!visited[i]) {

                Queue<Pair> queue = new LinkedList<>();

                queue.offer(new Pair(i, -1));
                visited[i] = true;

                while (!queue.isEmpty()) {

                    Pair current = queue.poll();

                    int node = current.node;
                    int parent = current.parent;

                    for (int neighbor : adj.get(node)) {

                        if (!visited[neighbor]) {

                            visited[neighbor] = true;
                            queue.offer(new Pair(neighbor, node));

                        } else if (neighbor != parent) {

                            return true;
                        }
                    }
                }
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