package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * jdbc的方法
 */
public class JDBCUtil {
    public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=shop";
    public static String name1 = "sa";
    public static String password = "123456";
    public static String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //必须写在后面
    //静态代码块
    static {
        //1.加载驱动
        try {
            Class.forName(JDBCUtil.drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        try {
            //连接数据库
            return DriverManager.getConnection(JDBCUtil.url, JDBCUtil.name1, JDBCUtil.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       public static void close(Connection con, Statement st, ResultSet res){
        try {
            if (st!=null){
                st.close();
            }
            if (con!=null){
                con.close();
            }
            if (res!=null){
                res.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
