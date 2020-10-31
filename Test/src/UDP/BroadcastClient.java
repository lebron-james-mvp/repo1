package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class BroadcastClient {
    public static void main(String[] args) {
        new BroadcastClient();
    }
    BroadcastClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String userInput;
                DatagramSocket sendSocket = null;
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                try {
                    sendSocket = new DatagramSocket();
                    System.out.println("线程1请输入用户名：");
                    String username = stdIn.readLine();
                    InetAddress address = InetAddress.getByName("127.0.0.1");
                    byte[] buf = null;
                    DatagramPacket packet = null;
                    while ((userInput = stdIn.readLine()) != null) {
                        buf = (username + ":" + userInput).getBytes();
                        packet = new DatagramPacket(buf, buf.length, address, 4445);
                        sendSocket.send(packet);

                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    if(sendSocket!=null){
                        sendSocket.close();
                    }
                    System.exit(1);
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                MulticastSocket socket=null;
                InetAddress address=null;
                try {
                    socket=new MulticastSocket(4446);
                    address=InetAddress.getByName("230.0.0.1");
                    socket.joinGroup(address);
                    DatagramPacket packet=null;
                    byte [] buf=new byte[256];
                    while (true){
                        packet=new DatagramPacket(buf,buf.length);
                        socket.receive(packet);
                        String received=new String(packet.getData(),0,packet.getLength());
                        System.out.println("客户端线程2接受广播消息："+received);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if(socket!=null){
                            socket.leaveGroup(address);
                            socket.close();
                        }
                        System.exit(1);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
