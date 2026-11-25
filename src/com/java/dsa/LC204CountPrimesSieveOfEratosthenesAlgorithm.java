
package com.java.dsa;

public class LC204CountPrimesSieveOfEratosthenesAlgorithm {

    static int sol(int n) {
        if (n <= 2) return 0;

        boolean[] composites = new boolean[n];

        // true -> composite, false -> potentially prime
        for (int i = 2; i * i < n; i++) {

            if (!composites[i]) {

                // Mark multiples of i starting from i * i
                for (int j = i * i; j < n; j += i) {
                    composites[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!composites[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(sol(10)); // Output: 4
    }
}
