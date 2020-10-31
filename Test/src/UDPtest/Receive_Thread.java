package UDPtest;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive_Thread extends Thread {
    private static final int MAX_RECEIVE_BUFFER = 1024;
    private DatagramSocket server;
    private DatagramPacket packet;
    byte[] buffer = new byte[MAX_RECEIVE_BUFFER];

    public Receive_Thread(DatagramSocket server) {
        this.server = server;
        packet = new DatagramPacket(buffer, buffer.length);
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.receive(packet);
                String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), "UTF-8");
                System.out.println(s + "----->消息来自IP：" + packet.getAddress());
                packet.setLength(buffer.length);
            }
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }
}
