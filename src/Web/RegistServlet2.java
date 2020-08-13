package Web;


import Util.DBCPUtil;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Arrays;
import java.util.Map;

@WebServlet(urlPatterns = "/ten")
public class RegistServlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dierge");
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String code = req.getParameter("code");
        //全部转换成小写
        String code1 = code.toLowerCase();
        System.out.println("this:" + code1);
        Statement st = null;
        PreparedStatement ps = null;


        //取出服务器生成的验证码
        String word = (String) this.getServletContext().getAttribute("check");
        System.out.println("hwo:" + word);

        if (code1.equals(word)) {
            Map<String, String[]> parameterMap = req.getParameterMap();
            for (Map.Entry<String, String[]> p : parameterMap.entrySet()) {
                System.out.print(p.getKey() + ":");
                System.out.println(Arrays.toString(p.getValue()));
            }

            User u = new User();

            try {
                BeanUtils.populate(u, parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //设置id
            // u.setId(UUID.randomUUID().variant());
            System.out.println(u);
            String name = req.getParameter("username");
            DataSource dataSource = DBCPUtil.getDataSource();
            QueryRunner qr=new QueryRunner(dataSource);
            String sql="select * from longin where username=?";
            User user=null;
            try {

                user=qr.query(sql,new BeanHandler<User>(User.class),name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(user);
            if (user!=null){
                System.out.println("已经被注册");
                resp.setHeader("refresh", "3;url=/_war_exploded/mystore/regist.jsp");
            }
            else {
                String sql2="insert into longin(username,password,tephone) values (?,?,?)";
                try {

                    int update = qr.update(sql2, u.getUsername(), u.getPassword(), u.getTephone());
                    resp.getWriter().write("注册成功");
                    resp.setHeader("refresh", "3;url=/_war_exploded/mystore/login.jsp");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }else{
                resp.getWriter().write("注册失败");
                resp.setHeader("refresh", "3;url=/_war_exploded/mystore/regist.jsp");
            }
        }
    }

