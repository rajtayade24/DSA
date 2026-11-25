import java.util.ArrayList;

public class L26CountInversion {
  // Brute force
  static int bruthSol(int[] arr) {
    int n = arr.length;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j])
          cnt++;
      }
    }
    return cnt;
  }

  // Merge function
  static int merge(int[] arr, int low, int mid, int high) {
    ArrayList<Integer> temp = new ArrayList<>();

    int left = low;
    int right = mid + 1;

    int cnt = 0;
    // Merge two sorted halves
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
        // right is smaller
      } else {
        temp.add(arr[right]);
        cnt += (mid - left + 1);
        right++;
      }
    }

    // Copy remaining elements from left half
    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }

    // Copy remaining elements from right half
    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }

    // Copy sorted elements back to original array
    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }

    return cnt;
  }

  // Recursive merge sort function
  static int mergeSort(int[] arr, int low, int high) {
    int cnt = 0;
    if (low >= high)
      return cnt;

    int mid = (low + high) / 2;

    // Sort left half
    cnt += mergeSort(arr, low, mid);

    // Sort right half
    cnt += mergeSort(arr, mid + 1, high);

    // Merge both halves
    cnt += merge(arr, low, mid, high);

    return cnt;
  }

  static int optimalSol(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1); // correct call
  }

  public static void main(String[] args) {
    int[] arr = { 5, 3, 2, 4, 1 };
    System.out.println("Count inversion Brute: " + bruthSol(arr));
    System.out.println("Count inversion Optimal: " + optimalSol(arr));
  }
}