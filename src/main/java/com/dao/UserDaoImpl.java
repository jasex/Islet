package com.dao;

import com.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;


public class UserDaoImpl extends BaseDao implements UserDao{
    private static UserDaoImpl userDao;
    private UserDaoImpl(){

    }
    public static UserDaoImpl getUserDaoImpl(){
        if(userDao==null){
            userDao=new UserDaoImpl();
        }
        return userDao;
    }

    /**
     * 根据username获取user
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<User> getUserByUserName(String name) throws SQLException {
        ArrayList<User> users=new ArrayList<>();
        User user=null;
        String sql="select * from user where username=?;";
        Object[] params={name};
        rs=this.ExecuteQuery(sql,params);

        while(rs.next()){
            String content=rs.getString(3);
            user=new User(name,content);
            users.add(user);
        }
        return users;
    }
}
