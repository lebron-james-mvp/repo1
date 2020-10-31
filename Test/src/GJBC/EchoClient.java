package GJBC;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Socket echoSocket = new Socket("127.0.0.1", 60);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            String inputLine;

            System.out.println("客户端加载成功！");
            new ouput().start();
            //  接受键盘传过来的数据
            while ((userInput = stdIn.readLine()) != null) {
                //向服务器发送消息
                out.println(userInput);
                //接受服务器发过来的消息，并输出屏幕
                System.out.println("我(用户) ：" + userInput);
            }


            while ((inputLine = in.readLine()) != null) {
                System.out.println("来自服务器端：" + inputLine);
                out.println(inputLine);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
 class  ouput extends  Thread{
     @Override
     public void run() {
         super.run();
         try {
             Socket   echoSocket = new Socket("127.0.0.1",60);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
             String userInput;
             String inputLine;
             while ((userInput = stdIn.readLine()) != null) {
                 //向服务器发送消息
                 out.println(userInput);
                 //接受服务器发过来的消息，并输出屏幕
                 System.out.println("我(用户) ：" + userInput);
             }

         } catch (IOException e) {
             e.printStackTrace();
         }

     }
 }

    public static void main(String[] args) {
        EchoClient echoClient=new EchoClient();
        echoClient.start();
    }
}
