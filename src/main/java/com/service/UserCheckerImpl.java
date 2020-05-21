package com.service;

import com.alibaba.fastjson.JSONObject;

import com.entities.User;
import com.service.util.CheckUtil;
import com.service.util.ParseReqToJson;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.StringTokenizer;

public class UserCheckerImpl implements UserChecker{
    private static UserCheckerImpl userChecker;
    private UserCheckerImpl(){

    }
    public static UserCheckerImpl getInstance(){
        if(userChecker==null){
            userChecker=new UserCheckerImpl();
        }
        return userChecker;
    }

    @Override
    public boolean checkUser(HttpServletRequest req) throws IOException {
        CheckUtil checkUtil=CheckUtil.getInstance();
        //解析Post，转化为实体类
        User user=ParseReqToJson.parseReq(req);

        System.out.println(user);
        //判断
        if(checkUtil.checkUser(user)){
            return true;
        }else {
            return false;
        }
    }
}
