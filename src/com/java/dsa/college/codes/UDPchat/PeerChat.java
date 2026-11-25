//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class PeerChat {
//    private static final int BUFFER_SIZE = 2048;
//
//    public static void main(String[] args) throws Exception {
//        if (args.length < 3 || !(args[0].equalsIgnoreCase("listen") || args[0].equalsIgnoreCase("connect"))) {
//            System.out.println("Usage:");
//            System.out.println("  java PeerChat listen <port> <name>");
//            System.out.println("  java PeerChat connect <peer-IP> <port> <name>");
//            return;
//        }
//
//        boolean listening = args[0].equalsIgnoreCase("listen");
//        int port;
//        InetAddress peerAddress = null;
//        String name;
//        DatagramSocket socket;
//        if (listening) {
//            port = Integer.parseInt(args[1]);
//            name = args[2];
//            socket = new DatagramSocket(port);
//            System.out.println("Waiting for a peer on UDP port " + port + "...");
//        } else {
//            if (args.length != 4) {
//                System.out.println("Usage: java PeerChat connect <peer-IP> <port> <name>");
//                return;
//            }
//            peerAddress = InetAddress.getByName(args[1]);
//            port = Integer.parseInt(args[2]);
//            name = args[3];
//            socket = new DatagramSocket();
//        }
//
//        try (socket) {
//            final DatagramSocket chatSocket = socket;
//            final AtomicBoolean connected = new AtomicBoolean(!listening);
//            final InetAddress[] remoteAddress = {peerAddress};
//            final int[] remotePort = {port};
//
//            Thread receiver = new Thread(() -> {
//                byte[] buffer = new byte[BUFFER_SIZE];
//                while (!chatSocket.isClosed()) {
//                    try {
//                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                        chatSocket.receive(packet);
//                        String message = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
//                        if (!connected.get()) {
//                            remoteAddress[0] = packet.getAddress();
//                            remotePort[0] = packet.getPort();
//                            connected.set(true);
//                            System.out.println("Peer connected from " + remoteAddress[0].getHostAddress());
//                        }
//                        if (packet.getAddress().equals(remoteAddress[0]) && packet.getPort() == remotePort[0]) {
//                            System.out.println(message);
//                        }
//                    } catch (IOException e) {
//                        if (!chatSocket.isClosed()) System.out.println("Receive error: " + e.getMessage());
//                        break;
//                    }
//                }
//            });
//            receiver.setDaemon(true);
//            receiver.start();
//
//            if (!listening) send(chatSocket, remoteAddress[0], remotePort[0], "[" + name + " joined]");
//            System.out.println("Type messages; /quit to exit.");
//            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//            String line;
//            while ((line = keyboard.readLine()) != null && !line.equalsIgnoreCase("/quit")) {
//                if (connected.get()) send(chatSocket, remoteAddress[0], remotePort[0], name + ": " + line);
//                else System.out.println("Waiting for the peer to connect.");
//            }
//        }
//    }
//
//    private static void send(DatagramSocket socket, InetAddress address, int port, String message) throws IOException {
//        byte[] data = message.getBytes(StandardCharsets.UTF_8);
//        socket.send(new DatagramPacket(data, data.length, address, port));
//    }
//}
