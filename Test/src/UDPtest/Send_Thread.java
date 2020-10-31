package UDPtest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Send_Thread  extends  Thread {
    private DatagramSocket sender = null;
    private InetSocketAddress address = null;
    Scanner scan = new Scanner(System.in);
    String username;
    public Send_Thread(DatagramSocket sender, InetSocketAddress address,String username) {
        this.sender = sender;
        this.address = address;
        this.username=username;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String input = username+":"+scan.nextLine();
                if (input.equals("exit"))
                    break;
                byte[] data = null;
                data = input.getBytes("UTF-8");
                DatagramPacket packet=new DatagramPacket(data,data.length,address);
                System.out.println("发送成功！-------->"+input);
                sender.send(packet);
            }
            System.out.println("Exit!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
