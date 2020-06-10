package dao2;

import pojo2.Goods;
import pojo2.Picture;
import pojo2.UserInfo;
import util2.DBUtil;

import java.util.List;

public class GoodDAO {


    //查总条数
    public int getCount() {
        String sql = "select count(*) from goods";
        int n = DBUtil.uniqueQuery(sql);
        return n;
    }

    public List<Goods> findall(int page, int size) {
        String sql = "select goodsid , goodsname , goodscount , goodsprice ,goodspic from goods limit ?, ?";
        List<Goods> list = DBUtil.query(sql, Goods.class, (page - 1) * size, size);
        return list;
    }

    public Goods findbyid(String goodsid) {
        String sql = "select goodsid , goodsname , goodscount , goodsprice ,goodspic from goods where goodsid = ?";
        List<Goods> list = DBUtil.query(sql, Goods.class, goodsid);

        String sql2 = "select pid,pname from picture where gid = ?";
        List<Picture> pictures = DBUtil.query(sql2,Picture.class,goodsid);


        if (list.size() == 0) {
            return null;
        }
        list.get(0).getSet().addAll(pictures);

        return list.get(0);


    }

}
