package Util;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtil {
    public static DataSource dbcp = null;

    static {
        //加载配置文件
        Properties p = new Properties();

        try {
            //获取字节码目录(User---只要是在同一个字节码目录里面就可以)
           String path = DBCPUtil.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream in = new FileInputStream(path);
            p.load(in);
            dbcp = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //获取数据源
    public static DataSource getDataSource(){
        return dbcp;
    }
    public static Connection getConn() {
        try {
            return dbcp.getConnection();
        } catch (Exception var1) {
            var1.printStackTrace();
            return null;
        }
    }
    public static void close(Connection con, Statement st, ResultSet res) {
        try {
            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }

            if (res != null) {
                res.close();
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
