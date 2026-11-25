package com.java.dsa.string;

import java.util.Arrays;

public class L8SortCharactersByFrequency {

    public String bucketSort(String s) {
        if (s == null || s.length() <= 1) return s;

        int[] freq = new int[256];

        for (char ch : s.toCharArray()) freq[ch]++;

        StringBuilder[] buckets = new StringBuilder[s.length() + 1];

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                int f = freq[i];

                if (buckets[f] == null)
                    buckets[f] = new StringBuilder();

                buckets[f].append((char) i);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int f = buckets.length - 1; f >= 1; f--) {
            if (buckets[f] == null) continue;

            for (char ch : buckets[f].toString().toCharArray()) {
                for (int k = 0; k < f; k++) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

    static String frequencySort(String s) {
        if (s == null || s.length() <= 1) return s;

        int[] freq = new int[256];

        for (char ch : s.toCharArray()) freq[ch]++;

        Character[] arr = s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        Arrays.sort(arr, (a, b) -> freq[b] - freq[a]);

        StringBuilder ans = new StringBuilder();
        for (char ch : arr) ans.append(ch);

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));    // eert
        System.out.println(frequencySort("cccaaa")); // cccaaa or aaaccc
        System.out.println(frequencySort("Aabb"));   // bbAa
    }
}