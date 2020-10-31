package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class EchoClient {
    public static void main(String[] args)  {
        DatagramSocket socket=null;
        String sendStr;
        try {
            socket =new DatagramSocket();
            BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in));
            while ((sendStr=stdIn.readLine())!=null){
                byte []buf=sendStr.getBytes();
                InetAddress address=InetAddress.getByName("127.0.0.1");
                DatagramPacket packet=new DatagramPacket(buf,buf.length,address,4455);
              //  System.out.println("ip为："+address+"端口号为:"+packet+" 的用户加载成功..");
                socket.send(packet);
                byte []buf1=new byte[256];
                packet=new DatagramPacket(buf1,buf1.length);
                socket.receive(packet);
                String received=new String(packet.getData(),0,packet.getLength());
                System.out.println("服务器接收到的信息：    "+received.trim()+"   来自："+packet.getAddress().getHostAddress()+":"+packet.getPort());
        }}  catch (UnknownHostException e) {
            e.printStackTrace();
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
