package JDBC.jdbc1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectStu {
    Connection con;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Student> list;
    public static void main(String[] args) throws SQLException {
        SelectStu selectStu = new SelectStu();
        System.out.println("数据库连接成功");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要查看小于该年龄的信息");
        int age=sc.nextInt();
        List<Student> list = selectStu.Select(age);
        if(list.size()==0){
            System.out.println("数据库中并没有查到小于"+age+"年龄的信息。");
            return;
        }

        System.out.println("年龄小于"+age+"的信息如下");
        for (Student s1 : list
        ) {
            System.out.println("学号:"+s1.getId()+"   名字:"+s1.getName()+"   年龄："+s1.getAge());
            System.out.println("-------------------------------------------------------");

        }

    }

    public SelectStu() throws SQLException {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String database = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(database, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        }
    public List<Student> Select(int  age) throws SQLException {
        try {
        list = new ArrayList<Student>();
        if (con != null) {
                pstmt = con.prepareStatement("select *from t_student where age< ?");
            pstmt.setInt(1,age);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setAge(rs.getInt("age"));
                    list.add(s);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(con!=null){
                con.close();
            }

        }

        return list;
    };

}
