package com.java.dsa.graph;

public class L7NumberOfProvinces {

    static void dfs(int i, boolean[] visited, int[][] isConnected) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, visited, isConnected);
            }
        }
    }

    static int selfTry(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, isConnected);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(selfTry(isConnected));
    }
}
