//package com.java.dsa.graph;
//
//import java.util.*;
//
//public class L30WordLadderII {
//
//    static class Pair {
//        String word;
//        int steps;
//
//        Pair(String word, int steps) {
//            this.word = word;
//            this.steps = steps;
//        }
//    }
//
//    private static List<List<String>> selfTry(String beginWord, String endWord, String[] wordList) {
////        Set<String> set = new HashSet<>();
////        set.addAll(Arrays.asList(wordList));
////
////        if (!set.contains(endWord)) {
////            return 0;
////        }
////
////        List<List<String>> ans = new ArrayList<>();
////        Set<List<String>> ans =new HashSet<>();
////
////        Queue<Pair> q = new LinkedList<>();
////        q.offer(new Pair(beginWord, 1));
////        set.remove(beginWord);
////
////        while (!q.isEmpty()) {
////            Pair p = q.poll();
////
////            String word = p.word;
////            int steps = p.steps;
////
////            if (word.equals(endWord)) {
////                return new ArrayList<>(ans);
////            }
////
////            char[] arr = word.toCharArray();
////
////            for (int i = 0; i < arr.length; i++) {
////                char original = arr[i];
////
////                for (char ch = 'a'; ch <= 'z'; ch++) {
////                    arr[i] = ch;
////                    String newWord = new String(arr);
////
////                    if (set.contains(newWord)) {
////                        q.offer(new Pair(newWord, steps + 1));
////
////                        set.remove(newWord);
////                    }
////                }
////
////                arr[i] = original;
////            }
////        }
////
////        return 0;
//
//        Set<String> set = new HashSet<>();
//        set.addAll(Arrays.asList(wordList));
//
//        if (!set.contains(endWord)) {
//            return new ArrayList<>();
//        }
//
//        Set<List<String>> ansSet = new HashSet<>();
//
//        Queue<List<String >> q = new LinkedList<>();
//        q.offer(Collections.singletonList(beginWord));
////        set.remove(beginWord);
//
//        int count = 1;
//
//        while (!q.isEmpty()) { // O(N)
//            int size = q.size();
//
//            for (int i = 0; i < size; i++) {
//                List<String> words= q.poll();
//
////                if (words.equals(endWord)) {
////                    return new ArrayList<>(ansSet);
////                }
//
//                char[] arr = words.getLast().toCharArray();
//
//                for (int j = 0; j < arr.length; j++) { // O(L)
//
//                    char original = arr[j];
//                    for (char ch = 'a'; ch <= 'z'; ch++) { // O(L26)
//                        arr[j] = ch;
//                        String newWord = new String(arr); // O(L)
//
//                        if (set.contains(newWord)) {
////                            q.offer(newWord);
//                            set.remove(newWord);
//                        }
//                    }
//
//                    arr[j] = original;
//                }
//            }
//
//            count++;
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String beginWord = "hit", endWord = "cog";
//
//        System.out.println(selfTry(beginWord, endWord, wordList));
//    }
//}
