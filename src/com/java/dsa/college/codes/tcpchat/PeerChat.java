//
//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//
//public class PeerChat {
//
//    public static void main(String[] args) throws IOException {
//
//        if (args.length < 2) {
//            System.out.println("Usage:");
//            System.out.println("User 1: java PeerChat listen 5000");
//            System.out.println("User 2: java PeerChat connect localhost 5000");
//            return;
//        }
//
//        Socket socket;
//        String userName;
//
//        if (args[0].equalsIgnoreCase("listen")) {
//            userName = "User 1";
//
//            int port = Integer.parseInt(args[1]);
//
//            try (ServerSocket listener = new ServerSocket(port)) {
//                System.out.println("Waiting for User 2...");
//                socket = listener.accept();
//            }
//
//        } else if (args[0].equalsIgnoreCase("connect")
//                && args.length == 3) {
//
//            userName = "User 2";
//
//            String ip = args[1];
//            int port = Integer.parseInt(args[2]);
//
//            socket = new Socket(ip, port);
//
//        } else {
//            System.out.println("Invalid arguments.");
//            return;
//        }
//
//        chat(socket, userName);
//    }
//
//    public static void chat(Socket socket, String userName)
//            throws IOException {
//
//        try (Socket connection = socket) {
//
//            BufferedReader networkIn = new BufferedReader(
//                new InputStreamReader(
//                    connection.getInputStream(),
//                    StandardCharsets.UTF_8));
//
//            PrintWriter networkOut = new PrintWriter(
//                new OutputStreamWriter(
//                    connection.getOutputStream(),
//                    StandardCharsets.UTF_8), true);
//
//            BufferedReader keyboard = new BufferedReader(
//                new InputStreamReader(System.in));
//
//            System.out.println("Connected as " + userName);
//            System.out.println("Type messages; /quit to exit.");
//
//            Thread sender = new Thread(() -> {
//                try {
//                    String message;
//
//                    while ((message = keyboard.readLine()) != null) {
//
//                        if (message.equalsIgnoreCase("/quit")) {
//                            break;
//                        }
//
//                        networkOut.println(userName + ": " + message);
//
//                        if (networkOut.checkError()) {
//                            break;
//                        }
//                    }
//
//                } catch (IOException e) {
//                    System.out.println("Keyboard input error.");
//                } finally {
//                    try {
//                        connection.close();
//                    } catch (IOException e) {
//                        // Connection is closing.
//                    }
//                }
//            });
//
//            sender.setDaemon(true);
//            sender.start();
//
//            try {
//                String received;
//
//                while ((received = networkIn.readLine()) != null) {
//                    System.out.println(received);
//                }
//
//            } catch (IOException e) {
//                if (!connection.isClosed()) {
//                    System.out.println("Connection interrupted.");
//                }
//            }
//
//            System.out.println("Chat ended.");
//        }
//    }
//}
