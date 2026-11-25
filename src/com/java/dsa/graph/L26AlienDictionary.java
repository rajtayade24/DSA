package com.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L26AlienDictionary {

    static String findOrder(String[] dict, int N, int K) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>(i));
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            for (int j = 0; j < Math.min(s2.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> sort = toposort(adj);

        StringBuilder sb = new StringBuilder();
        for (Integer el : sort) {
            sb.append((char) (el + 'a'));
        }

        return sb.toString();
    }

    static List<Integer> toposort(List<List<Integer>> adj) {

        int n = adj.size();

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }

        stack.push(node);
    }


    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = 5, K = 4;

        System.out.println(findOrder(dict, N, K));
    }
}
