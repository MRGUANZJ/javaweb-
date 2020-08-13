package Web;

import Util.DBCPUtil;
import domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品的服务器
 */
@WebServlet(urlPatterns = "/goods")
public class goodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        //连接数据库
//        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSource());
//        String sql="select * from goods";
//        List<Goods> allgood=null;
//        try {
//            allgood = runner.query(sql, new BeanListHandler<Goods>(Goods.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(allgood);
//        //把数据存放在requset
//        req.setAttribute("allgood",allgood);
//        //转发到商品列表面页，转发时把request对象传入
//        req.getRequestDispatcher("/mystore/goods_list.jsp").forward(req,resp);

        GoodsService goodsService = new GoodsService();
        List<Goods> allgood=goodsService.findAllGoods();
        System.out.println(allgood);
                //把数据存放在requset
        req.setAttribute("allgood",allgood);
        //转发到商品列表面页，转发时把request对象传入
        req.getRequestDispatcher("/mystore/goods_list.jsp").forward(req,resp);
    }
}
