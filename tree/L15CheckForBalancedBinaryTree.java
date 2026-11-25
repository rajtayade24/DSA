class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class L15CheckForBalancedBinaryTree {

  static int height(Node root) {
    if (root == null)
      return 0;

    int left = height(root.left);
    int right = height(root.right);

    if (left == -1 || right == -1)
      return -1;

    if (Math.abs(left - right) > 1)
      return -1;

    return Math.max(left, right) + 1;
  }

  static boolean checkForBalanceBinaryTree(Node root) {
    return height(root) != -1;
  }

  static void preorder(Node root) {
    if (root == null)
      return;

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  static Node insert(Node root, int data) {
    if (root == null) {
      return root = new Node(data);
    }

    if (data < root.data)
      root.left = insert(root.left, data);
    else
      root.right = insert(root.right, data);

    return root;
  }

  public static void main(String[] args) {

    Node root = new Node(13);
    insert(root, 9);
    insert(root, 20);
    insert(root, 15);
    insert(root, 50);

    preorder(root);
  }
}
