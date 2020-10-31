package JDBC.jdbc3;

import JDBC.jdb2.Dao;

import java.util.Scanner;

public class UpdateTest {

    public static void main(String[] args) throws Exception {
        Dao dao=new Dao();
        System.out.println("修改之前的值---------------------------------");
        dao.OutPut();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改年龄对应的id值a");
         int id=sc.nextInt();
        System.out.println("请输入要修改的年龄值b");
         int age=sc.nextInt();
//         dao.Update(id,age,name);
        System.out.println("修改之后的值---------------------------------");
        dao.OutPut();

    }
}
