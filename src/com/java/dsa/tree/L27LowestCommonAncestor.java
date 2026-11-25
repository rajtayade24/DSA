package com.java.dsa.tree;

public class L27LowestCommonAncestor {

    static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q)
            return root;

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else { // Both left and right are not null, we found our result
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();

        Node ans = lowestCommonAncestor(root, root.left, root.right);

        System.out.println(ans.data);
    }

    static Node buildTree() {
        Node root = new Node(3);

        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        return root;
    }
}
