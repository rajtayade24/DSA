//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class MultiChatClient {
//    private static final int DEFAULT_PORT = 6000;
//    private static final int BUFFER_SIZE = 4096;
//
//    public static void main(String[] args) throws Exception {
//        if (args.length < 2 || args.length > 3) {
//            System.out.println("Usage: java MultiChatClient <server-IP> <username> [port]");
//            return;
//        }
//        InetAddress serverAddress = InetAddress.getByName(args[0]);
//        String name = args[1];
//        int port = args.length == 3 ? Integer.parseInt(args[2]) : DEFAULT_PORT;
//
//        try (DatagramSocket socket = new DatagramSocket()) {
//            socket.setSoTimeout(0);
//            AtomicBoolean running = new AtomicBoolean(true);
//            send(socket, serverAddress, port, "JOIN\n" + name);
//            Thread receiver = new Thread(() -> {
//                byte[] buffer = new byte[BUFFER_SIZE];
//                while (running.get()) {
//                    try {
//                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                        socket.receive(packet);
//                        System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8));
//                    } catch (IOException e) {
//                        if (running.get()) System.out.println("Connection ended: " + e.getMessage());
//                        break;
//                    }
//                }
//            });
//            receiver.setDaemon(true);
//            receiver.start();
//
//            System.out.println("Connected to UDP chat. Type messages; /quit to leave.");
//            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//            String line;
//            while ((line = keyboard.readLine()) != null) {
//                send(socket, serverAddress, port, "MSG\n" + name + "\n" + line);
//                if (line.equalsIgnoreCase("/quit")) break;
//            }
//            running.set(false);
//        }
//    }
//
//    private static void send(DatagramSocket socket, InetAddress address, int port, String message) throws IOException {
//        byte[] data = message.getBytes(StandardCharsets.UTF_8);
//        socket.send(new DatagramPacket(data, data.length, address, port));
//    }
//}
