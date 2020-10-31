package TCP;

import java.util.Scanner;

public class Josepfu {

    public static void main(String[] args) {
        //测试一把小孩出圈是否正确
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入从第几位开始报数");
        int  start=sc.nextInt();
        System.out.println("请输入第几位开始死亡");
        int  dead=sc.nextInt();
        System.out.println("请输入总人数");
        int   total=sc.nextInt();

        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(total);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(start, dead, total);
    }

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);//
                boy.setNext(first);//
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何人质~~");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("人质的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while(true) {
            if(helper == first) {
                break;
            }

            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("人质%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("最后留在圈中的人质编号%d \n", first.getNo());

    }
}

class Boy {
    private int no;
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}