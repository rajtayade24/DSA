package com.java.dsa.heap;

import java.util.*;

public class LC1331RankTransformOfAnArray {

    static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int el : temp) {
            if (!map.containsKey(el)) {
                map.put(el, rank);
                rank++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    static class Pair {
        int val;
        int ind;

        Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    static int[] selfTry(int[] arr) {
        int n = arr.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(arr[i], i));
        }

        int[] ans = new int[n];
        int rank = 0;
        Integer last = null;

        while (!pq.isEmpty()) {
            Pair peek = pq.poll();

            if (last == null || last != peek.val) {
                rank++;
            }

            ans[peek.ind] = rank;
            last = peek.val;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};

        System.out.println(Arrays.toString(selfTry(arr)));
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
