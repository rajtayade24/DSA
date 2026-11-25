
public class L4ReverseArray {
  // Recursive function to reverse the array
  static int[] reverse(int[] arr, int left, int right) {
    if (left > right)
      return arr;

    // swap
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    return reverse(arr, left + 1, right - 1);
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    int[] result = reverse(arr, 0, arr.length - 1);

    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}
