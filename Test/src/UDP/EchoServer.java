package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServer {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket(4455);
            while (true){
                byte []buf=new byte[256];
                DatagramPacket packet=new DatagramPacket(buf,buf.length);
                socket.receive(packet);
                InetAddress clientAddress=packet.getAddress();
                int clientPort =packet.getPort();
              //  System.out.println("服务器加载成功");
                System.out.println(new String(packet.getData()).trim()+"     来自客户端:"+clientAddress.getHostAddress()+":"+clientPort);
                packet=new DatagramPacket(buf,buf.length,clientAddress,clientPort);
                socket.send(packet);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }

    }
}
