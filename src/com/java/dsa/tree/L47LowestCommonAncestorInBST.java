package com.java.dsa.tree;

public class L47LowestCommonAncestorInBST {

    static Node lca(Node root, Node p, Node q) {
        while (root != null) {

            if (p.data < root.data && q.data < root.data) {
                root = root.left;
            } else if (p.data > root.data && q.data > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    static Node selfTry(Node root, Node p, Node q) {

        if (p.data > q.data) {
            Node temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {

            if (root.data > p.data && root.data < q.data) {
                return root;
            }

            if (root.data > q.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = buildTree();

//        Node ans = lca(root, root.left, root.right);
        Node ans = selfTry(root, root.left.right.left, root.left.right.right);

        System.out.println("Ans: " + ans.data);
    }

    static Node buildTree() {
        Node root = new Node(6);

        root.left = new Node(2);
        root.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        return root;
    }

}
