
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;

public class UDPFileSender {

    static final int PORT = 5000;
    static final int CHUNK = 1200;
    static final int TIMEOUT = 2000;
    static final int MAX_ATTEMPTS = 10;

    static final int META = 1;
    static final int DATA = 2;
    static final int END = 3;
    static final int ACK = 4;
    static final int FIN = 5;

    // Create UDP packet
    static byte[] packet(int type, int id, int sequence,
                         byte[] payload, int length)
                         throws IOException {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);

        out.writeByte(type);
        out.writeInt(id);
        out.writeInt(sequence);
        out.writeShort(length);
        out.write(payload, 0, length);

        return bytes.toByteArray();
    }

    // Send packet and wait for matching ACK
    static void sendAndWait(DatagramSocket socket,
                            InetAddress receiver,
                            byte[] message,
                            int id, int sequence)
                            throws IOException {

        DatagramPacket outgoing = new DatagramPacket(
                message, message.length, receiver, PORT);

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {

            socket.send(outgoing);

            try {

                while (true) {

                    byte[] reply = new byte[100];

                    DatagramPacket incoming =
                            new DatagramPacket(reply, reply.length);

                    socket.receive(incoming);

                    if (!incoming.getAddress().equals(receiver)
                            || incoming.getPort() != PORT
                            || incoming.getLength() < 11) {
                        continue;
                    }

                    DataInputStream in = new DataInputStream(
                            new ByteArrayInputStream(
                                    reply, 0, incoming.getLength()));

                    int type = in.readUnsignedByte();
                    int acknowledgedId = in.readInt();
                    int acknowledgedSequence = in.readInt();

                    if (type == ACK
                            && acknowledgedId == id
                            && acknowledgedSequence == sequence) {

                        return;
                    }
                }

            } catch (SocketTimeoutException e) {

                System.out.println("Timeout! Retrying packet "
                        + sequence + " (attempt " + attempt + ")");

            }
        }

        throw new IOException(
                "Transfer failed. No ACK for packet " + sequence);
    }

    // Send one file
    static void sendFile(DatagramSocket socket,
                         InetAddress receiver,
                         Path file) throws IOException {

        if (!Files.isRegularFile(file) || !Files.isReadable(file)) {
            throw new FileNotFoundException("File not found: " + file);
        }

        int id = ThreadLocalRandom.current().nextInt();
        long size = Files.size(file);

        // Prepare file metadata
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream meta = new DataOutputStream(bytes);

        meta.writeUTF(file.getFileName().toString());
        meta.writeLong(size);

        byte[] metadata = bytes.toByteArray();

        if (metadata.length > CHUNK) {
            throw new IOException("Filename is too long.");
        }

        System.out.println("\nSending file: " + file);
        System.out.println("File size: " + size + " bytes");

        // Send META
        sendAndWait(socket, receiver,
                packet(META, id, -1, metadata, metadata.length),
                id, -1);

        System.out.println("Metadata acknowledged.");

        // Send DATA packets
        int sequence = 0;

        try (InputStream input = Files.newInputStream(file)) {

            byte[] chunk = new byte[CHUNK];
            int count;

            while ((count = input.read(chunk)) != -1) {

                sendAndWait(socket, receiver,
                        packet(DATA, id, sequence, chunk, count),
                        id, sequence);

                System.out.println("Packet " + sequence + " acknowledged.");

                sequence++;
            }
        }

        // Send END
        sendAndWait(socket, receiver,
                packet(END, id, sequence, new byte[0], 0),
                id, sequence);

        System.out.println("File transferred successfully: "
                + file.getFileName());
    }

    // Main method
    public static void main(String[] args) {

        if (args.length < 2) {

            System.out.println(
                    "Usage: java UDPFileSender <receiver-IP> <file1> [file2] ...");

            return;
        }

        try {

            InetAddress receiver = InetAddress.getByName(args[0]);

            try (DatagramSocket socket = new DatagramSocket()) {

                socket.setSoTimeout(TIMEOUT);

                // Send all files
                for (int i = 1; i < args.length; i++) {

                    sendFile(socket, receiver, Paths.get(args[i]));
                }

                // Send final FIN packet
                int finishId = ThreadLocalRandom.current().nextInt();

                sendAndWait(socket, receiver,
                        packet(FIN, finishId, 0, new byte[0], 0),
                        finishId, 0);

                System.out.println("\nAll files sent successfully!");
            }

        } catch (Exception e) {

            System.out.println("\nERROR: " + e.getMessage());
        }
    }
}
