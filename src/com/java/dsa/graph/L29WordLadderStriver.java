//package com.java.dsa.graph;
//
//import java.util.*;
//
//public class L29WordLadderStriver {
//
//
//
//
//    private static int selfTry(String beginWord, String endWord, String[] wordList) {
//        Set<String> set = new HashSet<>();
//        set.addAll(Arrays.asList(wordList));
//
//        if (!set.contains(endWord)) {
//            return 0;
//        }
//
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(new Pair(beginWord, 1));
//        set.remove(beginWord);
//
//        while (!q.isEmpty()) {
//            Pair p = q.poll();
//
//            String word = p.word;
//            int steps = p.steps;
//
//            if (word.equals(endWord)) {
//                return steps;
//            }
//
//            char[] arr = word.toCharArray();
//
//            for (int i = 0; i < arr.length; i++) {
//                char original = arr[i];
//
//                for (char ch = 'a'; ch <= 'z'; ch++) {
//                    arr[i] = ch;
//                    String newWord = new String(arr);
//
//                    if (set.contains(newWord)) {
//                        q.offer(new Pair(newWord, steps + 1));
//                        set.remove(newWord);
//                    }
//                }
//
//                arr[i] = original;
//            }
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        String[] wordList = {"hit", "hot", "dot", "dog", "cog"};
//        String beginWord = "hit", endWord = "cog";
//
//        System.out.println(selfTry(beginWord, endWord, wordList));
//    }
//}
