package ManyUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server {
    //分发给该段网络的所有服务器

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(888);
        byte b[]=new byte[1024];
        while(true){
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(b));
            for (int i = 1; i < 100; i++) {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                InetAddress byName = InetAddress.getByName("192.168.219."+i);
                DatagramPacket datagramPacket2 = new DatagramPacket(b, b.length, byName, 10086);
                datagramSocket2.send(datagramPacket2);

            }

        }
//        datagramSocket.close();

    }

}