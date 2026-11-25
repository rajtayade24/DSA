//package com.java.dsa.tree;
//
//import java.util.Stack;
//
//public class L50TwoSumIV {
//
//
//    static boolean selfTry(Node root, int target) {
//
//        Stack<Node> st1 = new Stack<>();
//        Stack<Node> st2 = new Stack<>();
//
//        Node temp1 = root;
//        Node temp2 = root;
//
//        while (temp2 != null || temp1 != null) {
//
//            // Go to the leftmost node
//            while (temp1 != null) {
//                st1.push(temp1);
//                temp1 = temp1.left;
//            }
//
//            // Go to the leftmost node
//            while (temp2 != null) {
//                st2.push(temp2);
//                temp2 = temp2.right;
//            }
//
//            int sum = st1.pop();
//            if (sum == target) {
//                return true;
//            } else if (sum < target) {
//                st1.pop();
//                temp1 = temp1.right;
//            } else {
//                temp2 = temp2.right;
//            }
//
//            // Process the node
//            temp1 = st1.pop();
//            ans.add(temp1.data);
//
//            // Move to right subtree
//        }
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Node root = buildTree();
//        int k = 9;
//
//        boolean ans = selfTry(root, k);
//
//        System.out.println("Ans: " + ans);
//    }
//
//    static Node buildTree() {
//        Node root = new Node(6);
//
//        root.left = new Node(2);
//        root.right = new Node(8);
//
//        root.left.left = new Node(0);
//        root.left.right = new Node(4);
//        root.right.left = new Node(7);
//        root.right.right = new Node(9);
//
//        root.left.right.left = new Node(3);
//        root.left.right.right = new Node(5);
//
//        return root;
//    }
//}
