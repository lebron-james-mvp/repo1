package MyTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servlet {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10086);
        System.out.println("服务器启动成功，等待连接.....");
        Socket s=ss.accept();
        System.out.println("连接成功");

        InputStreamReader sysin=new InputStreamReader(System.in);
        BufferedReader sysinBF=new BufferedReader(sysin);

        InputStreamReader  getinput=new InputStreamReader(s.getInputStream());
        BufferedReader  getinputBF=new BufferedReader(getinput);

        PrintWriter pout=new PrintWriter(s.getOutputStream());

        System.out.println("客户："+getinputBF.readLine());

        String sysinline=sysinBF.readLine();

        while (!sysinline.equals("bye")){
            pout.println(sysinline);
            pout.flush();

            System.out.println("服务器："+sysinline);
            String  getinpuLine=getinputBF.readLine();
            if(!getinpuLine.equals("ok")) {
                System.out.println("来自客户端：" + getinpuLine);
            }else {
                break;
            }
            sysinline=sysinBF.readLine();

        }
    }
}
