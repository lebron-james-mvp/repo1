package MyTcp;

import java.io.*;
import java.net.Socket;

public class User {
    public static void main(String[] args) throws IOException {
        String url="127.0.0.1";
        int port=10086;
        Socket s=new Socket(url,port);
        System.out.println("客户端连接成功");
        InputStreamReader sysin=new InputStreamReader(System.in);
        BufferedReader  sysinBF=new BufferedReader(sysin);

        InputStreamReader  getinput=new InputStreamReader(s.getInputStream());
        BufferedReader  getinputBF=new BufferedReader(getinput);

        PrintWriter   pout=new PrintWriter(s.getOutputStream());

        String sysreadline=sysinBF.readLine();
        while (!sysreadline.equals("bye")){
           pout.println(sysreadline);
            System.out.println("客户说："+sysreadline);
            pout.flush();
            System.out.println("来自服务器:"+getinputBF.readLine());
            sysreadline=sysinBF.readLine();
        }





    }

}
