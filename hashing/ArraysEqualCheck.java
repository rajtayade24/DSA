import java.util.*;

public class ArraysEqualCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input sizes
        System.out.print("Enter size of first array: ");
        int a = sc.nextInt();
        System.out.print("Enter size of second array: ");
        int b = sc.nextInt();

        if (a != b) {
            System.out.println("Both the arrays are not equal.");
            return;
        }

        int[] arr1 = new int[a];
        int[] arr2 = new int[b];

        System.out.println("Enter " + a + " elements in first array:");
        for (int i = 0; i < a; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter " + b + " elements in second array:");
        for (int i = 0; i < b; i++) {
            arr2[i] = sc.nextInt();
        }

        // frequency maps
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for (int num : arr1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        // compare maps
        if (freq1.equals(freq2)) {
            System.out.println("Both the arrays are equal.");
        } else {
            System.out.println("Both the arrays are not equal.");
        }

        sc.close();
    }
}
