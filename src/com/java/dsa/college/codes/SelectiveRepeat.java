//
//import java.util.Scanner;
//
//public class SelectiveRepeat {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter total number of frames: ");
//        int n = sc.nextInt();
//
//        System.out.print("Enter window size: ");
//        int window = sc.nextInt();
//
//        System.out.print("Enter frame number to simulate loss (0 for no loss): ");
//        int lostFrame = sc.nextInt();
//
//        int base = 1;
//
//        boolean[] received = new boolean[n + 1];
//
//        System.out.println("\n--- Selective Repeat Protocol Simulation ---");
//
//        while (base <= n) {
//
//            int end = Math.min(base + window - 1, n);
//
//            System.out.println("\nCurrent Window:");
//
//            for (int i = base; i <= end; i++) {
//                System.out.print("[" + i + "] ");
//            }
//
//            System.out.println("\nSending frames:");
//
//            for (int i = base; i <= end; i++) {
//
//                if (received[i]) {
//                    continue;
//                }
//
//                System.out.println("Frame " + i + " sent.");
//
//                if (i == lostFrame) {
//                    System.out.println("Frame " + i + " lost!");
//                } else {
//                    received[i] = true;
//                    System.out.println("Frame " + i + " received successfully.");
//                    System.out.println("ACK " + i + " received.");
//                }
//            }
//
//            if (lostFrame >= base && lostFrame <= end &&
//                !received[lostFrame]) {
//
//                System.out.println("\nTimeout for Frame " + lostFrame);
//
//                System.out.println("Retransmitting only Frame " + lostFrame);
//
//                received[lostFrame] = true;
//
//                System.out.println("Frame " + lostFrame + " received successfully.");
//                System.out.println("ACK " + lostFrame + " received.");
//            }
//
//            while (base <= n && received[base]) {
//                base++;
//            }
//
//            System.out.println("\nWindow slides forward.");
//
//        }
//
//        System.out.println("\nAll frames transmitted successfully.");
//
//        sc.close();
//    }
//}
