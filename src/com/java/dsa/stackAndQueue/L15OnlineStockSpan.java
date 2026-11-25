package com.java.dsa.stackAndQueue;

// write a program to insert, retrive and remove the record by using
// tree set is a collection of classes that strord the unique elements in sorted order

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// public class BruteSol {
//    List<Integer> list;
//
//    BruteSol() {
//        list = new ArrayList<>();
//    }
//
//    int next(int val) {
//        list.add(val);
//        int cnt = 1;
//        for (int i = list.size() - 2; i >= 0; i++) {
//            if (list.get(i) <= val) cnt++;
//            else break;
//        }
//        return cnt;
//    }
// }

public class L15OnlineStockSpan {

    private final Stack<int[]> stack;

    public L15OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }

    public static void main(String[] args) {

        L15OnlineStockSpan stockSpanner = new L15OnlineStockSpan();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}