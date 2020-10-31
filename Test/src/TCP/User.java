package TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class User extends Thread {

    Socket s = null;

    public User(String host, int port) {
        try {
            s = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        new JIANPAN().start();
        super.run();
        try {
            InputStream s = this.s.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = s.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class JIANPAN extends Thread{
        @Override
        public void run() {
            super.run();
            Scanner sc =null;
            OutputStream out = null;
            try {
                sc =new Scanner(System.in);
                out = s.getOutputStream();
                String in="";
                do {
                    in= sc.next();
                    out.write((""+in).getBytes());
                    out.flush();
                } while (!in.equals("拜拜"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        User user =new User("127.0.0.1", 8);
        user.start();
    }
}