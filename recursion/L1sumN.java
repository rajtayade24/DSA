public class L1sumN {
  // paameterized recursion
  static void sum(int i, int s) {
    if (i < 1) {
      System.out.println(s);
      return;
    }
    sum(i - 1, s + i);
  }
  
  // functional recursion
  static int sum(int n) {
    if (n <= 0)
      return 0;
    return n + sum(n - 1);
  }

  public static void main(String[] args) {
    System.out.println("sum: " + sum(5));
    sum(5, 0);
  }
}
