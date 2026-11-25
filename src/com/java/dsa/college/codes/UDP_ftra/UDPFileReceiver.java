
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class UDPFileReceiver {

    static final int PORT = 5000;
    static final int MAX_PACKET = 1300;

    static final int META = 1;
    static final int DATA = 2;
    static final int END = 3;
    static final int ACK = 4;
    static final int FIN = 5;

    // Send acknowledgement
    static void ack(DatagramSocket socket,
                    DatagramPacket received,
                    int id, int sequence) throws IOException {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);

        out.writeByte(ACK);
        out.writeInt(id);
        out.writeInt(sequence);
        out.writeShort(0);

        byte[] message = bytes.toByteArray();

        socket.send(new DatagramPacket(
                message,
                message.length,
                received.getAddress(),
                received.getPort()));
    }

    public static void main(String[] args) throws Exception {

        Path folder = Paths.get("ReceivedFiles");
        Files.createDirectories(folder);

        try (DatagramSocket socket = new DatagramSocket(PORT)) {

            System.out.println("UDP Receiver started.");
            System.out.println("Listening on port " + PORT);

            int activeId = -1;
            int lastId = -1;
            int next = 0;

            long expectedSize = 0;
            long receivedBytes = 0;

            OutputStream fileOut = null;
            String name = "";

            boolean finished = false;

            int lastEndSequence = -1;
            InetAddress lastAddress = null;
            int lastPort = -1;

            int finishId = -1;
            int finishSequence = -1;
            InetAddress finishAddress = null;
            int finishPort = -1;

            long finishDeadline = 0;

            while (!finished ||
                    System.nanoTime() < finishDeadline) {

                byte[] buffer = new byte[MAX_PACKET];

                DatagramPacket packet =
                        new DatagramPacket(buffer, buffer.length);

                if (finished) {
                    socket.setSoTimeout(1000);
                }

                try {
                    socket.receive(packet);
                } catch (SocketTimeoutException e) {
                    continue;
                }

                if (packet.getLength() < 11) {
                    continue;
                }

                DataInputStream in = new DataInputStream(
                        new ByteArrayInputStream(
                                buffer, 0, packet.getLength()));

                int type = in.readUnsignedByte();
                int id = in.readInt();
                int sequence = in.readInt();
                int length = in.readUnsignedShort();

                if (length > packet.getLength() - 11) {
                    continue;
                }

                // After FIN, acknowledge duplicate FIN packets only
                if (finished) {

                    if (type == FIN &&
                            id == finishId &&
                            sequence == finishSequence &&
                            length == 0 &&
                            packet.getAddress().equals(finishAddress) &&
                            packet.getPort() == finishPort) {

                        ack(socket, packet, id, sequence);
                    }

                    continue;
                }

                // Receive metadata
                if (type == META) {

                    if (id == activeId) {
                        ack(socket, packet, id, sequence);
                        continue;
                    }

                    if (fileOut != null) {
                        continue;
                    }

                    byte[] payload = new byte[length];
                    in.readFully(payload);

                    DataInputStream meta = new DataInputStream(
                            new ByteArrayInputStream(payload));

                    String supplied = meta.readUTF();
                    long size = meta.readLong();

                    if (size < 0) {
                        continue;
                    }

                    String safe = Paths.get(
                            supplied.replace('\\', '/'))
                            .getFileName().toString();

                    if (safe.isEmpty() || safe.equals(".")
                            || safe.equals("..")) {
                        continue;
                    }

                    name = safe;

                    fileOut = Files.newOutputStream(
                            folder.resolve(name));

                    activeId = id;
                    expectedSize = size;
                    receivedBytes = 0;
                    next = 0;

                    System.out.println("\nReceiving: " + name);
                    System.out.println("Expected size: "
                            + expectedSize + " bytes");

                    ack(socket, packet, id, sequence);
                }

                // Receive data
                else if (type == DATA && id == activeId) {

                    if (sequence == next &&
                            receivedBytes + length <= expectedSize) {

                        byte[] payload = new byte[length];
                        in.readFully(payload);

                        fileOut.write(payload);

                        receivedBytes += length;
                        next++;

                        System.out.println(
                                "Received packet: " + sequence);
                    }

                    // Acknowledge accepted and duplicate packets
                    if (sequence < next) {
                        ack(socket, packet, id, sequence);
                    }
                }

                // End of current file
                else if (type == END) {

                    if (id == activeId &&
                            sequence == next &&
                            length == 0 &&
                            receivedBytes == expectedSize) {

                        fileOut.close();
                        fileOut = null;

                        activeId = -1;

                        lastId = id;
                        lastEndSequence = sequence;
                        lastAddress = packet.getAddress();
                        lastPort = packet.getPort();

                        System.out.println(
                                "File saved: " + folder.resolve(name));

                        System.out.println(
                                "Received bytes: " + receivedBytes);

                        ack(socket, packet, id, sequence);
                    }

                    // Repeat ACK if previous END ACK was lost
                    else if (id == lastId &&
                            sequence == lastEndSequence &&
                            length == 0 &&
                            packet.getAddress().equals(lastAddress) &&
                            packet.getPort() == lastPort) {

                        ack(socket, packet, id, sequence);
                    }
                }

                // Sender has completed all files
                else if (type == FIN &&
                        length == 0 &&
                        fileOut == null) {

                    finishId = id;
                    finishSequence = sequence;

                    finishAddress = packet.getAddress();
                    finishPort = packet.getPort();

                    finished = true;

                    finishDeadline = System.nanoTime()
                            + 25_000_000_000L;

                    System.out.println(
                            "\nSender finished sending all files.");

                    ack(socket, packet, id, sequence);
                }
            }

            System.out.println("\nAll files received successfully!");
            System.out.println("Saved inside: " + folder.toAbsolutePath());
        }
    }
}
