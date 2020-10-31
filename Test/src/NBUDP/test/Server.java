package NBUDP.test;

import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class Server  implements Runnable {
    private DatagramSocket ds=null;
    //保存好客户端的地址和端口
    private ArrayList<SocketAddress> clients=new ArrayList<>();
    public Server() throws Exception {
        try {
            ds=new DatagramSocket(1234);
            new Thread(this).start();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                byte[] data=new byte[255];
                DatagramPacket dp=new DatagramPacket(data,data.length);
                ds.receive(dp);
                String msg = new String(dp.getData(), 0, dp.getLength());
                System.out.println(msg + "\n");
                //维护地址集合
                SocketAddress cAddress=dp.getSocketAddress();
                if(!clients.contains(cAddress))
                    clients.add(cAddress);

                //发送给所有客户端
                this.sendToAll(dp);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendToAll(DatagramPacket dp) throws Exception {
        for(SocketAddress sa:clients) {
            DatagramPacket datagramPacket=new DatagramPacket(dp.getData(),dp.getLength(),sa);
            ds.send(datagramPacket);
        }
    }

    public static void main(String[] args) throws Exception {
        new Server();
        System.out.println("服务器加载成功!");
    }
}