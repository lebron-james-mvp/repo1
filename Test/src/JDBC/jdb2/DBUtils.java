package JDBC.jdb2;


import java.sql.*;

public class DBUtils {
    private static String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=UTF-8";
    private static String user = "root";
    private static String pwd = "root";

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
