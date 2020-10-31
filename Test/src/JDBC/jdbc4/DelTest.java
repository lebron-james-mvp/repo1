package JDBC.jdbc4;

import JDBC.jdb2.Dao;

import java.util.Scanner;

public class DelTest {
    public static void main(String[] args) throws Exception {
        Dao dao=new Dao();
        System.out.println("删除之前的值-------------------");
        dao.OutPut();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入需要删除的id值");
        int id=sc.nextInt();
        dao.Del(id);
        System.out.println("删除之后的值----------------------" );
        dao.OutPut();
    }
}
