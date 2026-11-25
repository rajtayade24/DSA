//
//import java.io.*;
//import java.net.*;
//import java.nio.file.*;
//import java.util.Scanner;
//
//public class TcpLab {
//
//    static final int PORT = 5000;
//    static final String SERVER_IP = "localhost";
//    static final int BUFFER_SIZE = 8192;
//    static final long MAX_FILE_SIZE = 100_000_000L;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("===== TCP SOCKET PROGRAMMING =====");
//        System.out.println("1. Start Server");
//        System.out.println("2. Start Client");
//        System.out.print("Enter your choice: ");
//
//        int choice;
//
//        try {
//            choice = Integer.parseInt(sc.nextLine());
//
//            if (choice == 1) {
//                startServer();
//            } else if (choice == 2) {
//                startClient(sc);
//            } else {
//                System.out.println("Invalid choice!");
//            }
//
//        } catch (NumberFormatException e) {
//            System.out.println("Please enter a valid choice.");
//        } catch (IOException e) {
//            System.out.println("Network Error: " + e.getMessage());
//        }
//    }
//
//    // ================= SERVER =================
//
//    static void startServer() throws IOException {
//
//        ServerSocket server = new ServerSocket(PORT);
//
//        System.out.println("\nServer started successfully.");
//        System.out.println("Waiting for client on port " + PORT);
//
//        while (true) {
//
//            Socket socket = server.accept();
//
//            System.out.println("\nClient connected: "
//                    + socket.getInetAddress());
//
//            try (Socket client = socket;
//                 DataInputStream in =
//                         new DataInputStream(client.getInputStream());
//                 DataOutputStream out =
//                         new DataOutputStream(client.getOutputStream())) {
//
//                String operation = in.readUTF();
//
//                switch (operation) {
//
//                    case "HELLO":
//                        handleHello(in, out);
//                        break;
//
//                    case "FILE":
//                        handleFile(in, out);
//                        break;
//
//                    case "CALC":
//                        handleCalculator(in, out);
//                        break;
//
//                    default:
//                        out.writeUTF("ERROR: Invalid operation.");
//                        out.flush();
//                }
//
//            } catch (IOException e) {
//                System.out.println("Client operation failed: "
//                        + e.getMessage());
//            }
//
//            System.out.println("Client disconnected.");
//        }
//    }
//
//    // ================= HELLO =================
//
//    static void handleHello(DataInputStream in,
//                            DataOutputStream out) throws IOException {
//
//        String name = in.readUTF();
//
//        System.out.println("Client says: Hello! I am " + name);
//
//        String response =
//                "Hello " + name + "! I am the server.";
//
//        out.writeUTF(response);
//        out.flush();
//
//        System.out.println("Greeting sent to client.");
//    }
//
//    // ================= FILE TRANSFER =================
//
//    static void handleFile(DataInputStream in,
//                           DataOutputStream out) throws IOException {
//
//        String filename = in.readUTF();
//        long fileSize = in.readLong();
//
//        Path destination = null;
//        boolean fileCreated = false;
//
//        try {
//
//            if (filename == null || filename.isEmpty()
//                    || filename.contains("/")
//                    || filename.contains("\\")
//                    || filename.equals(".")
//                    || filename.equals("..")) {
//
//                throw new IOException("Invalid filename.");
//            }
//
//            if (fileSize < 0 || fileSize > MAX_FILE_SIZE) {
//                throw new IOException("Invalid file size.");
//            }
//
//            Path folder = Paths.get("received_files");
//
//            Files.createDirectories(folder);
//
//            destination = folder.resolve(filename);
//
//            // Prevent overwriting existing files
//            if (Files.exists(destination)) {
//                throw new IOException("File already exists on server.");
//            }
//
//            try (OutputStream fileOut =
//                         Files.newOutputStream(destination,
//                                 StandardOpenOption.CREATE_NEW,
//                                 StandardOpenOption.WRITE)) {
//
//                fileCreated = true;
//
//                byte[] buffer = new byte[BUFFER_SIZE];
//
//                long remaining = fileSize;
//
//                while (remaining > 0) {
//
//                    int bytesToRead =
//                            (int) Math.min(buffer.length, remaining);
//
//                    int bytesRead = in.read(buffer, 0, bytesToRead);
//
//                    if (bytesRead == -1) {
//                        throw new EOFException(
//                                "File transfer ended unexpectedly.");
//                    }
//
//                    fileOut.write(buffer, 0, bytesRead);
//
//                    remaining -= bytesRead;
//                }
//            }
//
//            out.writeUTF("File received successfully: " + filename);
//            out.flush();
//
//            System.out.println("File saved: " + destination);
//            System.out.println("File size: " + fileSize + " bytes");
//
//        } catch (IOException e) {
//
//            // Remove incomplete file
//            if (fileCreated && destination != null) {
//                Files.deleteIfExists(destination);
//            }
//
//            out.writeUTF("ERROR: " + e.getMessage());
//            out.flush();
//
//            System.out.println("File transfer failed: " + e.getMessage());
//        }
//    }
//
//    // ================= CALCULATOR =================
//
//    static void handleCalculator(DataInputStream in,
//                                 DataOutputStream out) throws IOException {
//
//        double num1 = in.readDouble();
//
//        String operator = in.readUTF();
//
//        double num2 = in.readDouble();
//
//        String result;
//
//        switch (operator) {
//
//            case "+":
//                result = "Result: " + (num1 + num2);
//                break;
//
//            case "-":
//                result = "Result: " + (num1 - num2);
//                break;
//
//            case "*":
//                result = "Result: " + (num1 * num2);
//                break;
//
//            case "/":
//
//                if (num2 == 0) {
//                    result = "ERROR: Division by zero is not allowed.";
//                } else {
//                    result = "Result: " + (num1 / num2);
//                }
//                break;
//
//            default:
//                result = "ERROR: Invalid operator.";
//        }
//
//        out.writeUTF(result);
//        out.flush();
//
//        System.out.println("Calculator response: " + result);
//    }
//
//    // ================= CLIENT =================
//
//    static void startClient(Scanner sc) throws IOException {
//
//        System.out.println("\n===== CLIENT MENU =====");
//        System.out.println("1. Say Hello");
//        System.out.println("2. File Transfer");
//        System.out.println("3. Calculator");
//
//        System.out.print("Enter your choice: ");
//
//        int choice;
//
//        try {
//            choice = Integer.parseInt(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid choice!");
//            return;
//        }
//
//        switch (choice) {
//
//            case 1:
//                helloClient(sc);
//                break;
//
//            case 2:
//                fileClient(sc);
//                break;
//
//            case 3:
//                calculatorClient(sc);
//                break;
//
//            default:
//                System.out.println("Invalid choice!");
//        }
//    }
//
//    // ================= HELLO CLIENT =================
//
//    static void helloClient(Scanner sc) throws IOException {
//
//        System.out.print("Enter your name: ");
//
//        String name = sc.nextLine();
//
//        try (Socket socket = new Socket(SERVER_IP, PORT);
//
//             DataInputStream in =
//                     new DataInputStream(socket.getInputStream());
//
//             DataOutputStream out =
//                     new DataOutputStream(socket.getOutputStream())) {
//
//            out.writeUTF("HELLO");
//            out.writeUTF(name);
//            out.flush();
//
//            String response = in.readUTF();
//
//            System.out.println("\nServer reply: " + response);
//        }
//    }
//
//    // ================= FILE CLIENT =================
//
//    static void fileClient(Scanner sc) throws IOException {
//
//        System.out.print("Enter file path: ");
//
//        String filePath = sc.nextLine();
//
//        Path source = Paths.get(filePath);
//
//        if (!Files.isRegularFile(source)
//                || !Files.isReadable(source)) {
//
//            System.out.println("Error: File does not exist or is unreadable.");
//            return;
//        }
//
//        long fileSize = Files.size(source);
//
//        if (fileSize > MAX_FILE_SIZE) {
//            System.out.println("Error: Maximum file size is 100 MB.");
//            return;
//        }
//
//        String filename = source.getFileName().toString();
//
//        try (Socket socket = new Socket(SERVER_IP, PORT);
//
//             DataInputStream in =
//                     new DataInputStream(socket.getInputStream());
//
//             DataOutputStream out =
//                     new DataOutputStream(socket.getOutputStream());
//
//             InputStream fileIn = Files.newInputStream(source)) {
//
//            out.writeUTF("FILE");
//            out.writeUTF(filename);
//            out.writeLong(fileSize);
//
//            byte[] buffer = new byte[BUFFER_SIZE];
//
//            int bytesRead;
//
//            while ((bytesRead = fileIn.read(buffer)) != -1) {
//
//                out.write(buffer, 0, bytesRead);
//            }
//
//            out.flush();
//
//            String response = in.readUTF();
//
//            System.out.println("\nServer reply: " + response);
//        }
//    }
//
//    // ================= CALCULATOR CLIENT =================
//
//    static void calculatorClient(Scanner sc) throws IOException {
//
//        double num1;
//        double num2;
//
//        System.out.print("Enter first number: ");
//
//        try {
//            num1 = Double.parseDouble(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid first number.");
//            return;
//        }
//
//        System.out.print("Enter operator (+, -, *, /): ");
//
//        String operator = sc.nextLine();
//
//        System.out.print("Enter second number: ");
//
//        try {
//            num2 = Double.parseDouble(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid second number.");
//            return;
//        }
//
//        try (Socket socket = new Socket(SERVER_IP, PORT);
//
//             DataInputStream in =
//                     new DataInputStream(socket.getInputStream());
//
//             DataOutputStream out =
//                     new DataOutputStream(socket.getOutputStream())) {
//
//            out.writeUTF("CALC");
//            out.writeDouble(num1);
//            out.writeUTF(operator);
//            out.writeDouble(num2);
//            out.flush();
//
//            String response = in.readUTF();
//
//            System.out.println("\nServer reply: " + response);
//        }
//    }
//}
