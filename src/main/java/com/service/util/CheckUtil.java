package com.service.util;

import com.dao.UserDaoImpl;
import com.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckUtil extends MD5Util{
    private CheckUtil(){

    }
    private static CheckUtil checkUtil;

    public static CheckUtil getInstance(){
        if(checkUtil==null){
            checkUtil=new CheckUtil();
        }
        return checkUtil;
    }

    public boolean checkUser(User user){
        UserDaoImpl userDao=UserDaoImpl.getUserDaoImpl();
        try{
            //数据库操作
            ArrayList<User> realUsers=userDao.getUserByUserName(user.getUsername());
            String encoded_password=getMD5String(user.getPassword());
            for(User u:realUsers){
                System.out.println(encoded_password);
                System.out.println(u);
                if(u.getPassword().equals(encoded_password)){
                    return true;
                }
            }
        }catch (NullPointerException | SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
