package com.java.dsa.tree;

public class L18CheckIfTwoTreesAreIdentical {

    static boolean isSameTree(Node p, Node q) {
        if (p == null || q == null)
            return p == q;

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right)
                && (p.data == q.data);
    }

    static boolean selfTry(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        boolean flag1 = isSameTree(p.left, q.left);
        boolean flag2 = isSameTree(p.right, q.right);

        return flag1 && flag2 && (p.data == q.data);
    }

    public static void main(String[] args) {
        Node root1 = buildTree1();
        Node root2 = buildTree2();

        System.out.println(isSameTree(root1, root2));
    }

    static Node buildTree1() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        return root;
    }

    static Node buildTree2() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        return root;
    }
}
