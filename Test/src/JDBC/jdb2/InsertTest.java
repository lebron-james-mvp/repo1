package JDBC.jdb2;

import java.util.Scanner;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        Dao dao=new Dao();
        System.out.println("添加前的数据---------------------------");
        dao.OutPut();
        System.out.println("请输入你需要插入几条语句");
        int  num=sc.nextInt();
        for (int i = 0; i <num ; i++) {
            System.out.println("请输入第"+(i+1)+"条语句的id值");
            int id=sc.nextInt();
            System.out.println("请输入第"+(i+1)+"条语句的name值");
            String name=sc.next();
            System.out.println("请输入第"+(i+1)+"条语句的age值");
            int age=sc.nextInt();
            dao.add(id,name,age);
        }
        System.out.println("添加后的数据库-----------------------------------");
        dao.OutPut();

    }
}
