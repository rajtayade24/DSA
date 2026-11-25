package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Introduction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] adj = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {
            System.out.print("Enter edge node\nu=");
            int u = sc.nextInt();

            System.out.print("v=");
            int v = sc.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1; // Undirected
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.print("Enter edge node\nu=");
            int u = sc.nextInt();

            System.out.print("v=");
            int v = sc.nextInt();

            list.get(u).add(v);
            list.get(v).add(u); // Undirected
        }
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
