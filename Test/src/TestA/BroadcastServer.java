package TestA;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BroadcastServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(4445);
            while (true) {
                byte buf[] = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                System.out.println(new String(packet.getData()).trim() + "    来自：" + clientAddress.getHostAddress() + ":" + clientPort);
                  InetAddress group=InetAddress.getByName("230.0.0.1");
                  packet=new DatagramPacket(buf,buf.length,group,4446);
                  socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null)
                socket.close();
        }

    }
}
