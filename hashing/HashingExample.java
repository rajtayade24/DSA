import java.util.Scanner;

public class HashingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] hash = new int[13]; // initialized to 0 by default
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && arr[i] < 13) {
                hash[arr[i]]++;
            } else {
                System.out.println("Value " + arr[i] + " is out of range (0–12), skipping.");
            }
        }

        // queries
        System.out.print("Number of queries: ");
        int q = sc.nextInt();

        while (q-- > 0) {
            int number = sc.nextInt();
            if (number >= 0 && number < 13) {
                System.out.println(hash[number]);
            } else {
                System.out.println("Out of range (0–12)");
            }
        }

        sc.close();
    }
}
