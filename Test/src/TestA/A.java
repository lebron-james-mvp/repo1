package TestA;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class A  extends JFrame{

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    A window = new A();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public A() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
        frame.setBounds(100, 100, 777, 478);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("\u7528\u6237\uFF1A");
        lblNewLabel.setFont(new Font("瀹嬩綋", Font.PLAIN, 23));
        lblNewLabel.setBounds(205, 120, 115, 33);
        frame.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
        label.setFont(new Font("瀹嬩綋", Font.PLAIN, 23));
        label.setBounds(205, 195, 115, 33);
        frame.getContentPane().add(label);

        textField = new JTextField();
        textField.setBounds(282, 120, 272, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(282, 195, 272, 33);
        frame.getContentPane().add(textField_1);


        //class Handle implements ActionListener{
        //public void actionPerformed(ActionEvent e) {









        JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u6765\u5230\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 41));
        lblNewLabel_1.setBounds(184, 27, 427, 58);
        frame.getContentPane().add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7BA1\u7406\u8005\r\n");
        rdbtnNewRadioButton.setFont(new Font("瀹嬩綋", Font.PLAIN, 18));
        rdbtnNewRadioButton.setBounds(234, 277, 121, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton radioButton = new JRadioButton("\u5B66\u751F");
        radioButton.setFont(new Font("瀹嬩綋", Font.PLAIN, 18));
        radioButton.setBounds(457, 277, 121, 23);
        frame.getContentPane().add(radioButton);

        JButton btnNewButton = new JButton("\u767B\u5F55");
        btnNewButton.setBounds(315, 319, 147, 41);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
        btnNewButton_1.setBounds(227, 386, 93, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton button = new JButton("\u4FEE\u6539\u5BC6\u7801");
        button.setBounds(485, 386, 93, 23);
        frame.getContentPane().add(button);


        btnNewButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = textField.getText();
                String s2 = textField_1.getText();

                if (rdbtnNewRadioButton.isSelected()) {
                    if (s1.equals("amy") && s2.equals("123456")) {
                        JOptionPane.showMessageDialog(null, "登录成功");
                        frame.dispose();
                        new W().setVisible(true);

                    }
                    else {
                        textField.setText("");
                        textField_1.setText("");
                        JOptionPane.showMessageDialog(null, "输入错误，请重新输入");
                         new W().dispose();
                    }
                }
            } });


        btnNewButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    if (textField.getText().equals("amy") && textField_1.getText().equals("123456")) {

                        JOptionPane.showMessageDialog(null, "登录成功");
                       frame. dispose();
                        new gt().setVisible(true);
                    }
                    else {

                        textField.setText("null");
                        textField_1.setText("null");
                        JOptionPane.showMessageDialog(null, "输入错误，请重新输入");
                        new gt().dispose();
                    }
                }

            }
        });






//        btnNewButton.addActionListener( new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(rdbtnNewRadioButton.isSelected()) {
//                    new W().setVisible(true);
//                }
//            }
//        });
//
//        btnNewButton.addActionListener( new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(radioButton.isSelected()) {
//                    new gt().setVisible(true);
//
//                }    }   });





    }
}


