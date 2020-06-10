package pojo2;

import java.util.HashSet;
import java.util.Set;

public class Goods {
    private int goodsid;
    private String goodsname ;
    private String goodspic;
    private int goodscount;
    private double goodsprice;

    public Set<Picture> getSet() {
        return set;
    }

    public void setSet(Set<Picture> set) {
        this.set = set;
    }

    private Set<Picture> set = new HashSet<Picture>();


    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodspic() {
        return goodspic;
    }

    public void setGoodspic(String goodspic) {
        this.goodspic = goodspic;
    }

    public int getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(int goodscount) {
        this.goodscount = goodscount;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }


    @Override
    public int hashCode() {
        return goodsid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Goods){
            if (((Goods) obj).getGoodsid()==this.goodsid){
                return true;
            }
        }
        return false;
    }
}