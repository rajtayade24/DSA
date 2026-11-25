import java.util.Arrays;
import java.util.Collections;

public class L24MergeSortedArrayWIthoutUsingExtraSpace {

  static void swap(int[] a1, int[] a2, int i, int j) {
    int temp = a1[i];
    a1[i] = a2[j];
    a2[j] = temp;
  }

  static void bruthSol(int[] a1, int[] a2) {
    int n1 = a1.length, n2 = a2.length;
    int i = 0, j = 0;
    int[] arr = new int[n1 + n2];

    while (i < n1 && j < n2) {
      if (a1[i] < a2[j]) {
        arr[i + j] = a1[i];
        i++;
      } else {
        arr[i + j] = a2[j];
        j++;
      }
    }

    while (i < n1) {
      arr[i + j] = a1[i];
      i++;
    }

    while (j < n2) {
      arr[i + j] = a2[j];
      j++;
    }

    for (int k = 0; k < n1 + n2; k++) {
      if (k < n1)
        a1[k] = arr[k];
      else
        a2[k - n1] = arr[k];
    }
  }

  static void betterSol(int[] a1, int[] a2) {
    int n1 = a1.length, n2 = a2.length;
    int i = n1 - 1, j = 0;

    while (i >= 0 && j < n2) {
      if (a1[i] > a2[j]) {
        swap(a1, a2, i, j);
        i--;
        j++;
      } else
        break;
    }
    Arrays.sort(a1);
    Arrays.sort(a2);
  }

  static void optimalSol(int[] a1, int[] a2) {
    int n1 = a1.length, n2 = a2.length;
    int len = n1 + n2;
    int gap = len / 2 + len % 2;

    while (gap > 0) {
      int left = 0, right = left + gap;

      while (right < len) {
        if (left < n1 && right >= n1) { // a1 & a2
          int i = left, j = right - n1;
          if (a1[i] > a2[j]) {
            swap(a1, a2, i, j);
          }
        } else if (left >= n1) { // a2 & a2
          int i = left - n1, j = right - n1;
          if (a2[i] > a2[j]) {
            swap(a2, a2, i, j);
          }
        } else {// a1 & a1
          int i = left, j = right;
          if (a1[i] > a1[j]) {
            swap(a1, a1, i, j);
          }
        }
        left++;
        right++;
      }
      if (gap == 1)
        break;
      gap = gap / 2 + gap % 2;
    }
  }

  // static void worstSol(int[] a1, int[] a2) {
  //   int n1 = a1.length, n2 = a2.length;
  //   int i = 0, j = 0;

  //   while (i < n1 && j < n2) {
  //     if (a1[i] > a2[j]) {
  //       swap(a1, a2, i, j);
  //       i++;
  //       for (int k = j; k < n2 - 1; k++) {
  //         if (a2[k] > a2[k + 1]) {
  //           swap(a2, a2, k, k + 1);
  //         } else
  //           break;
  //       }
  //     } else {
  //       i++;
  //     }
  //   }
  // }

  public static void main(String[] args) {
    int arr1[] = { 1, 3, 5, 7 };
    int arr2[] = { 0, 2, 6, 8, 9 };

    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.err.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.err.println();
    System.err.println();

    optimalSol(arr1, arr2);

    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.err.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.err.println();
  }
}
