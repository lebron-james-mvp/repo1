package GJBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends  Thread {
    @Override
    public void run() {
        new ouput().start();
        super.run();
        try {
            ServerSocket serverSocket = new ServerSocket(60);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader  in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            String serverInput;
            System.out.println("服务器端加载成功！");

            while ((inputLine=in.readLine())!=null){
                System.out.println("来自客户端："+inputLine);
                out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class  ouput extends  Thread{
        @Override
        public void run() {
            super.run();
            String serverInput;
            try {
             ServerSocket   serverSocket = new ServerSocket(10);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket .getOutputStream(), true);
                BufferedReader  in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                while ((serverInput = stdIn.readLine()) != null) {
                    //向服务器发送消息
                    out.println(serverInput);
                    //接受服务器发过来的消息，并输出屏幕
                    System.out.println("服务器(用户) ：" +serverInput);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        EchoServer echoServer=new EchoServer();
        echoServer.start();
    }
}
