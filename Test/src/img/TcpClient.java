package img;
import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[] args)throws Exception{
        String hostName = "127.0.0.1";// 服务器的iP地址，这里表示本机
        int portNumber = 23;
        try{
            //客户端通过创建Socket，通过服务器的IP地址和端口号，连接服务器
            Socket socket = new Socket(hostName, portNumber);
            //通过该Socket和服务器端通信，如果想向服务器发送消息，用Socket获取输出流
            //建立连接
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader InputReader = new BufferedReader(input);


            InputStreamReader GetInput = new InputStreamReader(socket.getInputStream());
            BufferedReader GetInputReader = new BufferedReader(GetInput);
            PrintWriter pout = new PrintWriter(socket.getOutputStream());


            //进行通信
            String readline = InputReader.readLine();
            while(!readline.equals("bye")){
                pout.println(readline);
                System.out.println("Client:" + readline);
                pout.flush();
                System.out.println("来自服务端:" + GetInputReader.readLine());
                readline = InputReader.readLine();
            }
            //关闭IO和Socket
            pout.close();
            GetInput.close();
            socket.close();
        }catch(Exception e){
            System.out.println("Error:" + e);
        }
    }
}