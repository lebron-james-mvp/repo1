package ManyChatTCP;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.WeakHashMap;

public class EchoMultiClient {
    public EchoMultiClient() {
        String hostName = "127.0.0.1";
        int portNumber = 8;
        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("客户端:" + echoSocket.getLocalAddress().getHostName() + ":" + echoSocket.getLocalPort()+"加载成功！");
            Scanner sc= new Scanner(System.in);
            System.out.println("请输入您的用户名：");
            String  username=stdIn.readLine();
            System.out.println("输入成功，可以开始您的聊天");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String userInput;
                    try {
                        while ((userInput = stdIn.readLine()) != null) {
                            out.println(username+":"+userInput);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    String receiveStr;
                    try {
                        while ((receiveStr = in.readLine()) != null) {
                            System.out.println(receiveStr);
                        }
                    } catch (Exception e) {
                  e.printStackTrace();
                  System.exit(1);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new EchoMultiClient();
    }
}
