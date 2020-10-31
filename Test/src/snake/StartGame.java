package snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);
        frame.setVisible(true);
       frame.add(new GamePanel());

    }
}
