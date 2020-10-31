package img;
import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args){
        try{
            //创建服务器端套接字，打开端口，用于监听来自客户端的连接请求
            ServerSocket server = new ServerSocket(23);
            //监听客户端的连接请求，如果监听到连接，则返回一个新的套接字
            Socket socket = server.accept();
            //建立连接
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader InputReader = new BufferedReader(input);


            InputStreamReader getInput = new InputStreamReader(socket.getInputStream());
            BufferedReader GetInputReader = new BufferedReader(getInput);

            PrintWriter pout = new PrintWriter(socket.getOutputStream());

            //通信
            System.out.println("Client:" + GetInputReader.readLine());




            String readline = InputReader.readLine();


            while(!readline.equals("bye")){
                pout.println(readline);
                pout.flush();
                System.out.println("Server:" + readline);

                String rl = GetInputReader.readLine();
                if(!rl.equals("ok"))
                    System.out.println("来自客户端:" + rl);
                else
                    break;

                readline = InputReader.readLine();
            }
            //关闭IO、Socket
            pout.close();
            getInput.close();
            server.close();
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }
}