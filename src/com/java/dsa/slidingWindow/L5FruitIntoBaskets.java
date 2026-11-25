package com.java.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class L5FruitIntoBaskets {

    static int usingSlidingWindowAlongMap(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            if (map.size() > 2) {

                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }
            if (map.size() <= 2)
                maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

    }
}
