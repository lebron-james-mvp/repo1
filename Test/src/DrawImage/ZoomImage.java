package DrawImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

public class ZoomImage extends JFrame{
    private  int imgWidth,imgHeight;
    private  double num;
    private JPanel jpanImg=null;
    private JPanel jpanBtn=null;
    private  JButton  jBtnBig=null;
    private  JButton   jBtnSmall=null;
    private CanvasTest canvas=null;
    public  ZoomImage(){
        initialize();
    }

    private void initialize() {
        this.setBounds(100, 100, 500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("图像缩放");
        jpanImg = new JPanel();
        canvas = new CanvasTest();
        jpanImg.setLayout(new BorderLayout());
        jpanImg.add(canvas, BorderLayout.CENTER);
        setContentPane(jpanImg);
        jBtnBig = new JButton("放大");
        jBtnSmall = new JButton("缩小");
         jBtnBig.addActionListener(new java.awt.event.ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 num+=20;
                 canvas.repaint();
             }
         });
        jBtnSmall.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num-=20;
                canvas.repaint();
            }
        });
        jpanBtn=new JPanel();
        jpanBtn.setLayout(new FlowLayout());
        jpanBtn.add(jBtnBig);
        jpanBtn.add(jBtnSmall);
        jpanImg.add(jpanBtn,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new ZoomImage().setVisible(true);
    }

   class CanvasTest extends  Canvas{
       @Override
       public void paint(Graphics g) {
            Image img=new ImageIcon("src/img/lakers.jpg").getImage() ;
            imgWidth=img.getWidth(this);
            imgHeight=img.getHeight(this);
            int newW=(int)(imgWidth+num);
            int newH=(int)(imgHeight+num);
            g.drawImage(img,0,0,newW,newH,this);


       }
   }
}
