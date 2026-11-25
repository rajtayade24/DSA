import java.util.*;

public class FrequencyMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

          // Create frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int j = 0; j < n; j++) {
            freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);
        }
        
        int q = sc.nextInt();
        while (q>0) {
            int number = sc.nextInt();
            System.out.println(freqMap.getOrDefault(number, 0));
        }


        // Scanner sc = new Scanner(System.in);

        // // input array size
        // System.out.print("Enter size of an array: ");
        // int n = sc.nextInt();

        // int[] arr = new int[n];
        // System.out.println("Enter elements in array: ");
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }

        // // frequency map
        // Map<Integer, Integer> freqMap = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        // freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        // }

        // // queries
        // System.out.print("Enter no. of queries: ");
        // int q = sc.nextInt();

        // while (q-- > 0) {
        // int number = sc.nextInt();
        // System.out.println(freqMap.getOrDefault(number, 0));
        // }

        // sc.close();
    }
}
