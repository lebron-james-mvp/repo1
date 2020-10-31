package NBUDP.test;

import javafx.scene.control.RadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private DatagramSocket datasocket =null;
    private String nickName=null;

    public Client() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的用户名：");
            nickName = sc.next();
            System.out.println("输入成功，请开始您的聊天");
            datasocket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            datasocket.connect(address, 1234);
            //特意给服务器发送一个包，告诉客户端其地址
            String msg = nickName + "登录！";
            byte[] data = msg.getBytes();
            DatagramPacket dp = new DatagramPacket(data, data.length);
            datasocket.send(dp);
        } catch (Exception ex) {
        }
        //接受的
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        byte[] data = new byte[255];
                        DatagramPacket dp = new DatagramPacket(data, data.length);
                        datasocket.receive(dp);
                        String msg = new String(dp.getData(), 0, dp.getLength());
                        System.out.println(msg + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
//发送的

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Scanner sc = new Scanner(System.in);
                        String info = sc.next();
                        String msg1 = nickName + "说：" + info;
                        byte[] data1 = msg1.getBytes();
                        DatagramPacket dp1 = new DatagramPacket(data1, data1.length);
                        datasocket.send(dp1);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();


    }



    public static void main(String[] args) throws Exception {
        new Client();
    }

}