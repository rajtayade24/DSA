public class MaxmimumConsecutiveOnce {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1 };
    int n = arr.length;

    int mx = 0, count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {  
        count++;
        if (mx < count)
          mx = count;
      } else {
        count = 0;
      }
    }
    System.out.print(mx);
  }
}
