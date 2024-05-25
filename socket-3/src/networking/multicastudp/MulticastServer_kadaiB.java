package networking.multicastudp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer_kadaiB {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 12345;

            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            System.out.println("Server started. Waiting for commands...");
            
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                multicastSocket.receive(packet);
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());

                System.out.println("Received command: " + receivedCommand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
