package lab.zlren.leetcode.test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) throws IOException {

        @SuppressWarnings("resource")
        DatagramSocket socket = new DatagramSocket(8888);
        DatagramPacket packet;
        byte[] data = new byte[100];

        while (true) {

            packet = new DatagramPacket(data, data.length);
            socket.receive(packet);

            String info = new String(packet.getData(), 0, packet.getLength());

            System.out.println(info);
        }
    }
}
