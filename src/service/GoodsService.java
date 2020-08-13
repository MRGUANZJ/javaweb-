package service;

import dao.GoodsDao;
import domain.Goods;
import java.util.List;

public class GoodsService {
    public List<Goods> findAllGoods(){
        GoodsDao goodsDao=new GoodsDao();
        return goodsDao.findAllGoods();
    }
}
