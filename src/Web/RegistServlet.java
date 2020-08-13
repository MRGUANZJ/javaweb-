package Web;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//        req.setCharacterEncoding("UTF-8");
//        String code = req.getParameter("code");
//        String name = req.getParameter("username");
//        //全部转换成小写
//        String code1 = code.toLowerCase();
//        System.out.println("this:" + code1);
//        Statement st = null;
//        PreparedStatement ps = null;
//
//
//        //取出服务器生成的验证码
//        String word = (String) this.getServletContext().getAttribute("check");
//        System.out.println("hwo:" + word);
//
//        if (code1.equals(word)) {
//            Map<String, String[]> parameterMap = req.getParameterMap();
//            for (Map.Entry<String, String[]> p : parameterMap.entrySet()) {
//                System.out.print(p.getKey() + ":");
//                System.out.println(Arrays.toString(p.getValue()));
//            }
//
//            User u = new User();
//
//            try {
//                BeanUtils.populate(u, parameterMap);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            //设置id
//            // u.setId(UUID.randomUUID().variant());
//            System.out.println(u);
//            Connection conn = null;
//            ResultSet res = null;
//            try {
//                //1.加载驱动
//                //驱动名称 com.microsoft.sqlserver.jdbc.SQLServerDriver
//                //1.6后可以不用写这个加载驱动，但是javaweb需要加
//                String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//                Class.forName(driverName);
//                long star = System.currentTimeMillis();
//                //2.获取连接对象
//                //url数据库地址，user用户名，password密码
//                String url = "jdbc:sqlserver://localhost:1433;DatabaseName=shop";
//                String name1 = "sa";
//                String password = "123456";
//                conn = DriverManager.getConnection(url, name1, password);
//                long end = System.currentTimeMillis();
//                System.out.println(conn);
//                System.out.println("连接时间是" + (end - star) + "毫秒");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            String sql = "SELECT * FROM longin WHERE username=?";
//            User user = null;
//            try {
//                ps = conn.prepareStatement(sql);
//                ps.setString(1, name);
//                res = ps.executeQuery();
//                if (res.next()) {
//                    User student = new User();
//                    student.setUsername(res.getString("username"));
//                    student.setPassword(res.getString("password"));
//                    student.setTephone(res.getString("tephone"));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            if (user.getUsername() != null) {
//                resp.getWriter().write("已经被注册了");
//                resp.setHeader("refresh", "3;url=/_war_exploded/mystore/regist.jsp");
//            } else {
//                String sql1 = "insert into longin values (?,?,?)";
//                try {
//                    ps = conn.prepareStatement(sql1);
//                    ps.setString(1, u.getUsername());
//                    ps.setString(2, u.getPassword());
//                    ps.setString(3, u.getTephone());
//                    ps.executeUpdate();
//                    System.out.println("插入成功");
//                    resp.getWriter().write("注册成功");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            }else{
//                resp.getWriter().write("注册失败");
//                resp.setHeader("refresh", "3;url=/_war_exploded/mystore/regist.jsp");
//            }
//        }
    }

