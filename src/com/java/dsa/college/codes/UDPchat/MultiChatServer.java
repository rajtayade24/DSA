//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MultiChatServer {
//    private static final int DEFAULT_PORT = 6000;
//    private static final int BUFFER_SIZE = 4096;
//    private static final Map<String, SocketAddress> clients = new ConcurrentHashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);
//        try (DatagramSocket server = new DatagramSocket(port)) {
//            System.out.println("UDP multi-chat server listening on port " + port);
//            byte[] buffer = new byte[BUFFER_SIZE];
//            while (true) {
//                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                server.receive(packet);
//                String text = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
//                String[] parts = text.split("\\n", 3);
//                if (parts.length < 2) continue;
//                String command = parts[0];
//                String name = parts[1].trim();
//                String body = parts.length == 3 ? parts[2] : "";
//                if (name.isEmpty()) continue;
//                String key = packet.getSocketAddress().toString();
//
//                if (command.equals("JOIN")) {
//                    clients.put(key, packet.getSocketAddress());
//                    broadcast(server, "[Server] " + name + " joined the chat.");
//                    send(server, packet.getSocketAddress(), "Welcome, " + name + ". Type /quit to leave.");
//                } else if (command.equals("MSG") && clients.containsKey(key)) {
//                    if (body.equalsIgnoreCase("/quit")) {
//                        clients.remove(key);
//                        broadcast(server, "[Server] " + name + " left the chat.");
//                    } else {
//                        broadcast(server, name + ": " + body);
//                    }
//                }
//            }
//        }
//    }
//
//    private static void broadcast(DatagramSocket socket, String message) throws IOException {
//        byte[] data = message.getBytes(StandardCharsets.UTF_8);
//        DatagramPacket packet = new DatagramPacket(data, data.length);
//        for (SocketAddress address : clients.values()) {
//            packet.setSocketAddress(address);
//            socket.send(packet);
//        }
//    }
//
//    private static void send(DatagramSocket socket, SocketAddress address, String message) throws IOException {
//        byte[] data = message.getBytes(StandardCharsets.UTF_8);
//        socket.send(new DatagramPacket(data, data.length, address));
//    }
//}
