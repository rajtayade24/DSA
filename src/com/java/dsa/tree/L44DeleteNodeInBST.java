package com.java.dsa.tree;

public class L44DeleteNodeInBST {

    static Node selfTry(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return helper(root);
        }

        Node dummy = root;
        while (root != null) {
            if (val < root.data) {
                if (root.left != null && root.left.data == val) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == val) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    static Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node rightChild = root.right;

            Node lastRightOfLeft = findLastRight(root.left);

            lastRightOfLeft.right = rightChild;

            return root.left;
        }
    }

    static Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        int key = 3;

        System.out.println(selfTry(root, key).data);
    }

    static Node buildTree() {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(6);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.right = new Node(7);

        return root;
    }
}
