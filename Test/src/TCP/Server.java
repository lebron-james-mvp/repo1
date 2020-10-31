package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public  class Server extends Thread{
    ServerSocket ss = null;
    Socket s = null;

    public Server(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){

        super.run();
        try{
            System.out.println("等待连接哦....");
            s = ss.accept();
            new JIANPAN().start();
            System.out.println("IP为"+s.getInetAddress().getHostAddress()+"的用户连接成功！...");
            InputStream in = s.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len=in.read(buf))!=-1){
                System.out.println("客户端说： "+new String(buf,0,len));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    class JIANPAN extends Thread{
        @Override
        public void run(){
            super.run();
            Scanner sc =null;
            OutputStream out = null;
            try{
                if(s != null){
                    sc = new Scanner(System.in);
                    out = s.getOutputStream();
                    String in = "";
                    do {
                        in = sc.next();
                        out.write(("服务器说： "+in).getBytes());
                        out.flush();
                    }while (!in.equals("q"));
                    sc.close();
                    try{
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //函数入口
    public static void main(String[] args) {
        Server server = new Server(8);
        server.start();
    }
}