package TestA;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class W extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private Container panel1;
    private JTable table;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    W frame = new W();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public W() {
        setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u8005");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 813, 501);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(28, 10, 752, 412);
        contentPane.add(tabbedPane);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("图书管理", null, panel_2, null);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("个人信息", null, panel_1, null);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
        lblNewLabel.setBounds(76, 126, 122, 35);
        panel_1.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(155, 126, 190, 32);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("\u7528\u6237\u804C\u4F4D\uFF1A");
        label.setFont(new Font("宋体", Font.PLAIN, 24));
        label.setBounds(76, 194, 122, 35);
        panel_1.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(191, 200, 190, 32);
        panel_1.add(textField_1);

        JLabel lblid = new JLabel("\u804C\u4F4DID\u53F7\uFF1A");
        lblid.setFont(new Font("宋体", Font.PLAIN, 24));
        lblid.setBounds(76, 277, 122, 35);
        panel_1.add(lblid);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(191, 277, 190, 32);
        panel_1.add(textField_2);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u9986\u7CFB\u7EDF\u7528\u6237\u4FE1\u606F");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 27));
        lblNewLabel_1.setBounds(119, 47, 416, 32);
        panel_1.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        tabbedPane.addTab("图书查阅", null, panel, null);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65B9\u5F0F");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        lblNewLabel_2.setBounds(82, 22, 182, 36);
        panel.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7167\u4E66\u540D\u67E5\u8BE2", "\u6309\u7167\u4F5C\u8005\u67E5\u8BE2", "", "", ""}));
        comboBox.setBounds(85, 80, 169, 21);
        panel.add(comboBox);

        textField_3 = new JTextField();
        textField_3.setBounds(289, 80, 273, 21);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("\u641C\u7D22");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.setBounds(598, 79, 93, 23);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 109, 680, 264);
        panel.add(scrollPane);


        scrollPane.setViewportView(table);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {{"1","白书","幸福来敲门"},
                        {"2","绿书","正能量使者"}
                },

                new String[] {
                        "\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u7C7B\u578B"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(table_1);

        //Container panel1 = getContentPane();
        //JTb1 ta = new JTb1();
        //JScrollPane sp = new JScrollPane(ta);
        //panel1.add(sp);



        //JButton btnNewButton = new JButton("\u641C\u7D22");
        //btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
        //btnNewButton.setBounds(589, 79, 93, 23);

        //panel1.add(btnNewButton);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("修改信息", null, panel_3, null);
    }
}
