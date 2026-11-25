//import java.util.Scanner;
//
//public class CRCAscii {
//
//    // Convert text into 8-bit ASCII binary
//    static String asciiToBinary(String text) {
//
//        String binary = "";
//
//        for (char ch : text.toCharArray()) {
//
//            int ascii = (int) ch;
//
//            for (int i = 7; i >= 0; i--) {
//                binary = binary + ((ascii >> i) & 1);
//            }
//        }
//
//        return binary;
//    }
//
//
//    // Perform CRC division
//    static String crcDivision(String data, String generator) {
//
//        char[] temp = data.toCharArray();
//
//        int dataLength = temp.length;
//        int generatorLength = generator.length();
//
//        for (int i = 0; i <= dataLength - generatorLength; i++) {
//
//            if (temp[i] == '1') {
//
//                for (int j = 0; j < generatorLength; j++) {
//
//                    if (temp[i + j] == generator.charAt(j)) {
//                        temp[i + j] = '0';
//                    }
//                    else {
//                        temp[i + j] = '1';
//                    }
//                }
//            }
//        }
//
//        // Return remainder
//        return new String(
//            temp,
//            dataLength - generatorLength + 1,
//            generatorLength - 1
//        );
//    }
//
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        // Step 1: Take input
//        System.out.print("Enter ASCII text: ");
//        String text = sc.nextLine();
//
//        System.out.print("Enter generator polynomial in binary: ");
//        String generator = sc.nextLine();
//
//
//        // Step 2: Convert text to binary
//        String binaryData = asciiToBinary(text);
//
//        System.out.println("\nASCII Data in Binary:");
//        System.out.println(binaryData);
//
//
//        // Step 3: Add zeros
//        int zeros = generator.length() - 1;
//
//        String appendedData = binaryData;
//
//        for (int i = 0; i < zeros; i++) {
//            appendedData = appendedData + "0";
//        }
//
//        System.out.println("\nData after adding zeros:");
//        System.out.println(appendedData);
//
//
//        // Step 4: Find CRC
//        String crc = crcDivision(appendedData, generator);
//
//        System.out.println("\nCRC Remainder:");
//        System.out.println(crc);
//
//
//        // Step 5: Create transmitted codeword
//        String transmittedData = binaryData + crc;
//
//        System.out.println("\nTransmitted Codeword:");
//        System.out.println(transmittedData);
//
//
//        // Step 6: Receive codeword
//        System.out.print("\nEnter received codeword: ");
//        String receivedData = sc.nextLine();
//
//
//        // Step 7: Check received data
//        String remainder = crcDivision(receivedData, generator);
//
//        System.out.println("\nReceiver Remainder:");
//        System.out.println(remainder);
//
//
//        // Step 8: Check for error
//        boolean error = false;
//
//        for (char bit : remainder.toCharArray()) {
//
//            if (bit == '1') {
//                error = true;
//                break;
//            }
//        }
//
//
//        if (error) {
//
//            System.out.println("Error detected by CRC!");
//            System.out.println("Retransmission is required.");
//
//        }
//        else {
//
//            System.out.println("No error detected.");
//            System.out.println("Data accepted by receiver.");
//        }
//
//
//        sc.close();
//    }
//}