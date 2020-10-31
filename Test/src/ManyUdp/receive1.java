package ManyUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class receive1 {

    public static void main(String[] args) throws Exception {
        System.out.println("软件工程56班聊天群");
        DatagramSocket datagramSocket = new DatagramSocket(10086);

        byte b[]=new byte[1024];
        while(true){
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length);

            datagramSocket.receive(datagramPacket);
            System.out.println(new String(b));
        }

    }

}