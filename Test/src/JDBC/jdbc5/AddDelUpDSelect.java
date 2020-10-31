package JDBC.jdbc5;

import JDBC.jdb2.Dao;

import java.util.Scanner;

public class AddDelUpDSelect {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("请输入你要进行的操作，1为增加，2为删除，3为修改，4为查询，0为退出");
            int num=sc.nextInt();
            switch (num ){
                case 0:break;
                case  1:
                    Dao dao=new Dao();
                    System.out.println("增加之前的数据库——————————————————————-");
                    dao.OutPut();
                    System.out.println("请输入要增加的id");
                    int id=sc.nextInt();
                    System.out.println("请输入要增加的name");
                    String name=sc.next();
                    System.out.println("请输入要增加的年龄age");
                    int age=sc.nextInt();
                    dao.add(id,name,age);
                    System.out.println("增加之后的数据库——————————————————————-");
                    dao.OutPut();
                    break;
                case 2:

                    Dao dao1=new Dao();
                    System.out.println("删除前的数据库——————————————————————");
                    dao1.OutPut();
                    System.out.println("请输入要删除的id值");
                    int id1=sc.nextInt();
                    dao1.Del(id1);
                    System.out.println("删除后的数据库——————————————————————");
                    dao1.OutPut();
                    break;
                case 3:

                    Dao dao2=new Dao();
                    System.out.println("修改之前的数据库______________");
                    dao2.OutPut();
                    System.out.println("请输入修改的id记录");
                    int id2=sc.nextInt();
                    System.out.println("请输入要修改的名字");
                    String name2=sc.next();
                    System.out.println("请输入要修改的年龄");
                    int age2=sc.nextInt();
                    dao2.Update(id2,name2,age2);
                    System.out.println("修改之后的数据库______________");
                    dao2.OutPut();
                    break;
                case  4:Dao dao3=new Dao();
                    System.out.println("查询结果为：");
                    dao3.OutPut();
                    break;
            }
        }
    }
}
