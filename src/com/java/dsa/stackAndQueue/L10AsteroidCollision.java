package com.java.dsa.stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L10AsteroidCollision {

    static List<Integer> sol(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                stack.push(asteroid);
            } else {

                while (!stack.isEmpty()
                        && stack.peek() > 0
                        && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        return new ArrayList<>(stack);
    }


    static List<Integer> slightlyBetterSol(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty()
                    && asteroid < 0
                    && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Positive asteroid is smaller
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both destroy each other
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Negative asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] asteroids = {3, 5, -6, 2, -1, 4}; // [-6,2,4]

        System.out.println(sol(asteroids));
    }
}
