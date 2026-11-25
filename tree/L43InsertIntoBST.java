
class node {
  int data;
  node left;
  node right;

  public node(int key) {
    data = key;
    left = null;
    right = null;
  }
}

public class L43InsertIntoBST {

  public node insert(node root, int data) {
    if (root == null)
      return new node(data);

    node cur = root;
    while (true) {
      if (cur.data <= data) {
if(cur.right != null)
      }
    }
  }

  public static void main(String[] args) {

    node root = new node(1);
    root.left = new node(2);
    root.right = new node(3);

  }
}
