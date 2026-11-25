//package com.java.dsa.graph;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class L12CourseSchedule {
//
//    static boolean canFinish(int numCourses, int[][] prerequisites) {
//
//        List<List<Integer>> adjList = new ArrayList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        for (int[] prerequisite : prerequisites) {
//            adjList.get(prerequisite[1]).add(prerequisite[0]);
//        }
//
//        boolean[] visited = new boolean[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            if (!visited[i]) {
//                if (dfs(i, -1, visited, adjList)) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//
//    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
//
//        visited[node] = true;
//
//        for (int adjNode : adjList.get(node)) {
//            if (!visited[adjNode]) {
//                if (dfs(adjNode, node, visited, adjList)) {
//                    return false;
//                }
//            }
//            else if (adjNode!=parent) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    static boolean selfTry(int numCourses, int[][] prerequisites) {
//
//        List<List<Integer>> adjList = new ArrayList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        for (int[] prerequisite : prerequisites) {
//            adjList.get(prerequisite[1]).add(prerequisite[0]);
//        }
//
//        boolean[] visited = new boolean[numCourses];
//        boolean[] pathVisited = new boolean[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            if (!visited[i]) {
//                if (dfs(i, adjList, visited, pathVisited)) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    static boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
//        visited[node] = true;
//        pathVisited[node] = true;
//
//        for (int neighbor : adjList.get(node)) {
//            if (pathVisited[neighbor]) {
//                return true;   // cycle found
//            }
//
//            if (!visited[neighbor]) {
//                if (dfs(neighbor, adjList, visited, pathVisited)) {
//                    return true;
//                }
//            }
//        }
//        pathVisited[node] = false;
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int numCourses = 5;
//
//        int[][] prerequisites = {
//                {1, 0},
//                {2, 0},
//                {3, 0},
//                {4, 3},
//                {5, 4},
//                {6, 5},
//                {7, 6},
//                {2, 7}
//        };
//
//        System.out.println(selfTry(numCourses, prerequisites));
//    }
//}
//