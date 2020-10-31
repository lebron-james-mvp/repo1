package libs;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener,Runnable {
    private JTextArea taMsg=new JTextArea("以下是聊天记录\n");
    private JTextField tfMsg=new JTextField();
    private DatagramSocket ds=null;
    private String nickName=null;
    public Client(){
        this.setTitle("客户端");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(taMsg,BorderLayout.CENTER);
        tfMsg.setBackground(Color.yellow);
        this.add(tfMsg,BorderLayout.SOUTH);
        tfMsg.addActionListener(this);
        this.setSize(280,400);
        this.setVisible(true);
        nickName=JOptionPane.showInputDialog("输入昵称");
        try {
            ds=new DatagramSocket();
            InetAddress add=InetAddress.getByName("127.0.0.1");
            ds.connect(add,9999);
            JOptionPane.showMessageDialog(this,"连接成功");
            //特意给服务器发送一个包，告诉客户端其地址
            String msg=nickName+"登录！";
            byte[] data=msg.getBytes();
            DatagramPacket dp=new DatagramPacket(data,data.length);
            ds.send(dp);
            new Thread(this).start();
        }
        catch (Exception ex) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] data=new byte[255];
                DatagramPacket dp=new DatagramPacket(data,data.length);
                ds.receive(dp);
                String msg=new String(dp.getData(),0,dp.getLength());
                taMsg.append(msg+"\n"); //添加内容
            }
        }
        catch (Exception ex) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String msg=nickName+"说："+tfMsg.getText();
            byte[] data=msg.getBytes();
            DatagramPacket dp=new DatagramPacket(data,data.length);
            ds.send(dp);
        }
        catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        new Client();
    }
}