package ManyChatTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class EchoServerThread extends Thread {
    Socket myClient;
    List<Socket> clients;
    String clientHostname;
    int clientPort;
    String username;

    public EchoServerThread(Socket myClient, List<Socket> clients) {
        super();
        this.myClient = myClient;
        this.clients = clients;
    }

    @Override
    public void run() {
        InetSocketAddress clientAddress = (InetSocketAddress) myClient.getRemoteSocketAddress();
        clientHostname = clientAddress.getHostName();
        clientPort = clientAddress.getPort();
        System.out.println("第" + clients.size() + "个客户端已连接" + ",它的IP是: " + clientHostname + " 端口号是: " + clientPort);
        try {
            String inStr;
            BufferedReader in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
            while ((inStr = in.readLine()) != null) {
                System.out.println("来自IP为: " + clientHostname + ",端口号为：" + clientPort + "  的用户说:------>" + inStr);
                for (Socket client : clients) {
                    if (client != null) {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println(inStr + "            ————>来自IP为" + clientHostname + "，端口号:" + clientPort + "");

                    }

                }
            }
        } catch (IOException e) {
            System.err.println(clientHostname + ":" + clientPort + "退出了");
        }
    }
}
