//
//import java.util.Scanner;
//
//public class GoBackN {
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
//        System.out.println("\n--- Go-Back-N Protocol Simulation ---");
//
//        while (base <= n) {
//
//            int end = Math.min(base + window - 1, n);
//
//            System.out.println("\nCurrent Window: ");
//
//            for (int i = base; i <= end; i++) {
//                System.out.print("[" + i + "] ");
//            }
//
//            System.out.println("\nSending frames:");
//
//            boolean loss = false;
//
//            for (int i = base; i <= end; i++) {
//
//                System.out.println("Frame " + i + " sent.");
//
//                if (i == lostFrame) {
//                    System.out.println("Frame " + i + " lost!");
//                    loss = true;
//                    break;
//                } else {
//                    System.out.println("Frame " + i + " received.");
//                }
//            }
//
//            if (loss) {
//
//                System.out.println("\nTimeout occurred!");
//                System.out.println("Retransmitting from frame " + lostFrame);
//
//                for (int i = lostFrame; i <= end; i++) {
//                    System.out.println("Retransmitting Frame " + i);
//                    System.out.println("Frame " + i + " received successfully.");
//                }
//
//                lostFrame = 0;
//            }
//
//            System.out.println("\nAcknowledgement received up to Frame " + end);
//
//            base = end + 1;
//
//            System.out.println("Window slides forward.");
//
//        }
//
//        System.out.println("\nAll frames transmitted successfully.");
//
//        sc.close();
//    }
//}
