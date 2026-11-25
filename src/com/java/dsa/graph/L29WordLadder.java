package com.java.dsa.graph;

import java.util.*;

public class L29WordLadder {

    private static int selfTry(String beginWord, String endWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(wordList));

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);

        int count = 1;

        while (!q.isEmpty()) { // O(N)
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) { // O(L)

                    char original = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) { // O(L26)
                        arr[j] = ch;
                        String newWord = new String(arr); // O(L)

                        if (set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    arr[j] = original;
                }
            }

            count++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hit","hot","dot","dog","cog"};
        String beginWord = "hit", endWord = "cog";

        System.out.println(selfTry(beginWord, endWord, wordList));
    }
}
