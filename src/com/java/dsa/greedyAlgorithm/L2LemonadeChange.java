package com.java.dsa.greedyAlgorithm;

public class L2LemonadeChange {

    static boolean selfTry(int[] bills) {

        int five = 0, ten = 0, twenty = 0;

        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                ten++;
                if (five > 0) five--;
                else return false;
            } else {
                twenty++;
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) five -= 3;
                else return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};

        System.out.println(selfTry(bills));
    }
}
