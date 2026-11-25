package com.java.dsa.greedyAlgorithm;

import java.util.Arrays;

public class L1AssignCookies {

    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                j++;
            }
            i++;
        }
        return j;
    }

    public static void main(String[] args) {
        int[] g = {1, 5, 3, 3, 4};
        int[] s = {4, 2, 1, 2, 1, 3};

        System.out.println(findContentChildren(g, s));
    }
}
