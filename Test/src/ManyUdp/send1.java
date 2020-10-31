package ManyUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class send1 {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress byName = InetAddress.getByName("127.0.0.1");//如果别的主机要测试此处ip应该为192.168.219.61，即服务器的ip
        System.out.println("欢迎来到多人聊天室");
        Scanner scanner = new Scanner(System.in);
        String username=scanner.nextLine();
        while(true){
            System.out.println("请输入:");
            String str=scanner.nextLine();
            str=username+"说:"+str;
        System.out.println(str);
            byte b[]=str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length, byName, 8888);
            datagramSocket.send(datagramPacket);
            if(str.equals("拜拜"))
            {
                System.out.println("退出");
                break;
            }
        }
        datagramSocket.close();


    }

}
