package dao2;

import pojo2.Collection;
import pojo2.UserInfo;
import util2.DBUtil;

import java.util.List;

public class UserDAO {


    public UserInfo login (String username, String password){
        String sql = "select username,password from userinfo where username =? and pasword =?";
        List<UserInfo> list = DBUtil.query(sql,UserInfo.class,username,password);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }
    public List<Collection> check(String username, String goodsid){
        String sql = "select goodsid, username from collection where username = ? and goodsid = ?";
        List<Collection> list = DBUtil.query(sql, Collection.class,username,goodsid);
        return list;
    }
    public void addcollection(String username,String goodsid){
        String sql = "insert into collection(username,goodsid) values(?,?)";
        DBUtil.zsg(sql,username,goodsid);
    }

}
