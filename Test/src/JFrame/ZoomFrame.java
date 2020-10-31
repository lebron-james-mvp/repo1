package JFrame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZoomFrame extends JFrame {
    private JTextField tf_height;
    private JTextField tf_width;
    private Image img = null; // 声明图像对象
    private ZoomFramePanel imgPanel; // 声明图像面板对象
    private int imgWidth, imgHeight; // 图片的宽度和高度
    private int widthScale, heightScale; // 图片的宽度和高度的缩放比例
    private int newWidth, newHeight; // 图片缩放后的宽度和高度

    public static void main(String args[]) {
        ZoomFrame frame = new ZoomFrame();
        frame.setVisible(true);
    }

    public ZoomFrame() {
        super();
        this.setBounds(100, 100, 355, 275); // 设置窗体大小和位置
        this.setTitle("根据输入的宽、高缩放比例对图片进行缩放"); // 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式

        URL imgUrl = ZoomFrame.class.getResource("/img/lakers.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图像资源
        imgPanel = new ZoomFramePanel(); // 创建图像面板对象
        getContentPane().add(imgPanel); // 在窗体中部位置添加图像面板对象
        getContentPane().add(imgPanel, BorderLayout.CENTER); // 在窗体中部位置添加图像面板对象

        JPanel zoomScalePanel = new JPanel();
        getContentPane().add(zoomScalePanel, BorderLayout.SOUTH);

        JLabel lbl_height = new JLabel("高度(H):");
        zoomScalePanel.add(lbl_height);

        tf_height = new JTextField();
        tf_height.setText("100");
        zoomScalePanel.add(tf_height);
        tf_height.setColumns(4);

        JLabel lbl_heightPercent = new JLabel("%");
        zoomScalePanel.add(lbl_heightPercent);

        JLabel lbl_width = new JLabel("宽度(W):");
        zoomScalePanel.add(lbl_width);

        tf_width = new JTextField();
        tf_width.setText("100");
        zoomScalePanel.add(tf_width);
        tf_width.setColumns(4);

        JLabel lbl_widthPercent = new JLabel("%");
        zoomScalePanel.add(lbl_widthPercent);

        JButton btn_zoom = new JButton("缩放");
        btn_zoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    widthScale = Integer.parseInt(tf_width.getText());
                    heightScale = Integer.parseInt(tf_height.getText());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "文本框中的文本内容不能为空……", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (widthScale % 10 != 0 || heightScale % 10 != 0) {
                    JOptionPane.showMessageDialog(null, "文本框输入的数值必须是10的倍数……", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                imgPanel.repaint();// 重新调用面板类的paint()方法
            }
        });
        zoomScalePanel.add(btn_zoom);
    }

    // 创建面板类
    class ZoomFramePanel extends JPanel {
        public void paint(Graphics g) {
            g.clearRect(0, 0, this.getWidth(), this.getHeight());// 清除绘图上下文的内容
            imgWidth = img.getWidth(this); // 获取图片宽度
            imgHeight = img.getHeight(this); // 获取图片高度
            widthScale = Integer.parseInt(tf_width.getText());
            heightScale = Integer.parseInt(tf_height.getText());
            newWidth = (int) (imgWidth * widthScale / 100); // 计算图片缩放后的宽度
            newHeight = (int) (imgHeight * heightScale / 100); // 计算图片缩放后的高度
            g.drawImage(img, 0, 0, newWidth, newHeight, this); // 绘制指定大小的图片
        }
    }
}
