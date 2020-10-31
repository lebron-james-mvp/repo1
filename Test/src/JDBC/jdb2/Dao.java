package JDBC.jdb2;


import JDBC.jdbc1.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {

    public ArrayList ForList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList stuList = new ArrayList();
        try {
            conn = DBUtils.getConn();
            String sql = "SELECT * FROM  t_student";//表名books
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                stuList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, rs);
        }
        return stuList;
    }

    public void OutPut() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConn();
            String sql = "SELECT * FROM  t_student";//表名books
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("id  "+"name  "+" age");
            while (rs.next()) {
                System.out.print(rs.getInt(1)+"  "+rs.getString("name")+"  "+rs.getInt("age"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, rs);
        }
    }


    public void add(int  id, String name,int age) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConn();
            String sql = "insert into  t_student values (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3,age);
            pstmt.executeUpdate();
        } catch (Exception e) {
        } finally {
            DBUtils.close(conn, pstmt, rs);
        }

    }

    public void Del(int  id) throws Exception{
        PreparedStatement pstmt = null;
        Connection   conn=null;
        ResultSet rs = null ;

        try{
            conn = DBUtils.getConn();
            String sql="delete from t_student where id= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }catch (Exception e) {
        }finally {
            DBUtils.close(conn,pstmt,rs);
        }
    }


    public void Update(int id, String name ,int age) throws Exception{
        PreparedStatement pstmt = null;
        Connection   conn=null;
        ResultSet rs = null ;

        try{
            conn = DBUtils.getConn();
            String sql="update t_student  set age=? ,name=? where id =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, age);
            pstmt.setString(2,name);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        }catch (Exception e) {
        }finally {
            DBUtils.close(conn,pstmt,rs);
        }
    }

}
