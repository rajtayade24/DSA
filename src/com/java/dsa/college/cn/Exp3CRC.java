
package com.java.dsa.college.cn;

import java.util.Scanner;

public class Exp3CRC {

    // Convert text into 8-bit binary
    static String toBinary(String data) {
        String binary = "";

        for (char ch : data.toCharArray()) {
            String bits = Integer.toBinaryString(ch);

            while (bits.length() < 8) {
                bits = "0" + bits;
            }

            binary = binary + bits;
        }

        return binary;
    }

    // Perform CRC division using XOR
    static String divide(String data, String divisor) {
        char[] bits = data.toCharArray();

        for (int i = 0; i <= bits.length - divisor.length(); i++) {

            if (bits[i] == '1') {

                for (int j = 0; j < divisor.length(); j++) {

                    if (bits[i + j] == divisor.charAt(j)) {
                        bits[i + j] = '0';
                    } else {
                        bits[i + j] = '1';
                    }
                }
            }
        }

        int length = divisor.length() - 1;

        return new String(bits).substring(bits.length - length);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter data: ");
        String data = sc.nextLine();

        System.out.print("Enter divisor: ");
        String divisor = sc.nextLine();

        if (!divisor.matches("[01]+") ||
                divisor.length() < 2 ||
                divisor.charAt(0) != '1' ||
                divisor.charAt(divisor.length() - 1) != '1') {

            System.out.println("Invalid divisor!");
            sc.close();
            return;
        }

        // Sender side
        String binaryData = toBinary(data);

        System.out.println("\nSender Side");
        System.out.println("Binary Data: " + binaryData);

        String appendedData = binaryData +
                "0".repeat(divisor.length() - 1);

        String crc = divide(appendedData, divisor);

        String transmittedData = binaryData + crc;

        System.out.println("CRC: " + crc);
        System.out.println("Transmitted Data: " + transmittedData);

        // Receiver side
        System.out.println("\nReceiver Side");

        System.out.print("Enter received data (Enter to use original): ");
        String receivedData = sc.nextLine();

        if (receivedData.isEmpty()) {
            receivedData = transmittedData;
        }

        if (!receivedData.matches("[01]+") ||
                receivedData.length() < divisor.length()) {

            System.out.println("Invalid received data!");

        } else {

            String remainder = divide(receivedData, divisor);

            System.out.println("Remainder: " + remainder);

            if (remainder.contains("1")) {
                System.out.println("Error detected!");
            } else {
                System.out.println("No error detected. Data accepted.");
            }
        }

        sc.close();
    }
}
