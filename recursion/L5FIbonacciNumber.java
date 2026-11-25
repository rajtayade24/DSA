public class L5FIbonacciNumber {

  static int fib(int n) {
    if (n <= 1)
      return n; // TC = O(2^n)

    return fib(n - 1) + fib(n - 2);
  }
// We consider index number in the recursion
  public static void main(String[] args) {
    System.out.println("nth fibonacci number is: " + fib(6));
  }
}
