package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A  extends JFrame  {
    A(){
        Container c=this.getContentPane()   ;
        JButton jButton=new JButton("FMVP");
        c.add(jButton);
        setBounds(50,50,300,300);
        setVisible(true);
        setTitle("父窗体");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new B().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new A();
    }
}
