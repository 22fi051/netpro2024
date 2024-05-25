package networking.multicastudp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient_kadaiB {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 12345;

            DatagramSocket socket = new DatagramSocket();

            String command = "SOME_COMMAND";

            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + command);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
