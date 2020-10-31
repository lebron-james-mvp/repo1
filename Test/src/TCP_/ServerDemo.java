package TCP_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    服务器：接收到的数据在控制台输出
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器加载中,等待连接.....");
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(1000);

        //监听客户端的连接，返回一个对应的Socket对象
        Socket s = ss.accept();
        System.out.println("连接成功！");
        //获取输入流
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader GetInputReader = new BufferedReader(isr);


        String line= GetInputReader.readLine();
        while (!line.equals("bye")) {
            System.out.println("客户端:"+line);
        }



        //输出
        BufferedReader InputReader = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
//        BufferedWriter InputReader = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line1= InputReader.readLine();
        while (!line1.equals("bye")) {
            System.out.println("Servlet:"+line1);
            if(!line.equals("ok")){
                System.out.println("来自客户端："+line);
            }
            else {
                break;
            }
            line1=InputReader.readLine();
        }


        //释放资源
        ss.close();
    }
}
