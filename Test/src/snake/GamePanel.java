package snake;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //定义蛇的数据结构
    int length;
    int[] snakeX = new int[600]; //蛇的X坐标
    int[] snakeY = new int[500]; //蛇的Y坐标
    String fx;
    int foodx;
    int foody;
    Random random = new Random();
    int score = 0;
    //游戏当前状态
    boolean isStart = false; //默认是不开始
    boolean isFail = false;
    Timer timer = new Timer(100, this);//100毫秒执行一次


    public GamePanel() {
        init();
        //获得键盘焦点事件
        this.setFocusable(true); //获得焦点事件
        this.addKeyListener(this);//获得键盘监听
        timer.start();//游戏一开始就启动

    }

    //初始化
    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        fx = "R";
        foodx = 25 + 25 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);

    }


    //绘制面板画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        //绘制静态面板
        this.setBackground(Color.PINK);
        Data.header.paintIcon(this, g, 25, 11);//头部广告栏
        g.fillRect(25, 75, 850, 600);//默认游戏界面
     
        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度:"+length,750,35);
        g.drawString("分数:"+score,750,50);
        Data.food.paintIcon(this, g, foodx, foody);
        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);//蛇头初始化向右
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);//蛇头初始化向右
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);//蛇头初始化向右
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);//蛇头初始化向右
        }
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);//第一个身体的坐标
        }

        if (isStart == false) {
            g.setColor(Color.WHITE);
            //设置字体
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始由此", 300, 300);
        }
        if (isFail) {
            g.setColor(Color.red);
            //设置字体
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("垃圾这都能输？", 300, 300);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {//空格
            if (isFail) {
                isFail = false;
                init();
            } else {
                isStart = !isStart;
            }
            repaint();
        }
        if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        } else if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //事件监听，需要通过固定的事件来刷新 1s=10次
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && isFail == false) {//如果游戏是开始状态
            //吃食物
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                length++;
                score+=10;
                //再次随机生成食物
                foodx = 25 + 25 * random.nextInt(34);
                foody = 75 + 25 * random.nextInt(24);
            }
            //移动
            for (int i = length - 1; i > 0; i--) {//后一节移到前一节的位置
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            //走向
            if (fx.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            //失败判断，撞到自己就算失败
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }
            repaint();
        }
        timer.start();
    }
}
//键盘监听器


