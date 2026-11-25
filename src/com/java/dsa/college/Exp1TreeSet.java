package com.java.dsa.college;

import java.util.TreeSet;

public class Exp1TreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println("Set: " + set);

        System.out.println("First element: " + set.first());

        System.out.println("Last element: " + set.last());

        set.remove(20);

        System.out.println(set);

        System.out.println("Name: " + "Raj Tayade");
        System.out.println("PRN: " + "RBT24CS068");
        System.out.println("Roll No.: " + "63 (A division)");
    }
}
