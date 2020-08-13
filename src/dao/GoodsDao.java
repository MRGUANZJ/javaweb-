package dao;

import Util.DBCPUtil;
import domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {

    public List<Goods> findAllGoods() {
            QueryRunner queryRunner=new QueryRunner(DBCPUtil.getDataSource());
            String sql="select * from goods";
        List<Goods> goodsList=null;
        try {
            goodsList= queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }
}
