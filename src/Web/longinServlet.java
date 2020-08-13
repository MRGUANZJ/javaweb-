package Web;

import Util.DBCPUtil;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/longin")
public class longinServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String pad = req.getParameter("password");
        DataSource source = DBCPUtil.getDataSource();
        System.out.println(source);
        QueryRunner qr = new QueryRunner(source);
        System.out.println(qr);
        String sql="SELECT * FROM longin WHERE username=? AND password=?";
        User user=null;
        try {
            user  = qr.query(sql, new BeanHandler<User>(User.class), name, pad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null){
            resp.getWriter().write("登陆成功");

            //把用户保存
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            System.out.println(session);
            resp.setHeader("refresh", "3;url=/_war_exploded/mystore/index.jsp");
        }else {
            resp.getWriter().write("登录失败");
            resp.setHeader("refresh", "3;url=/_war_exploded/mystore/login.jsp");
        }

    }
}
