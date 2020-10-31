package ManyChatTCP;

import TCP.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoMultiServer {
    ServerSocket serverSocket;
    List<Socket> clients = new ArrayList<Socket>();

    public EchoMultiServer() {
        try {
            serverSocket = new ServerSocket(8);
            System.out.println("服务器加载成功!");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                new EchoServerThread(clientSocket, clients).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new EchoMultiServer();
    }
}
