package com.service.util;

import com.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.io.DataInputStream;
import java.io.*;
import java.util.StringTokenizer;


public class ParseReqToJson {
    public static User parseReq(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        char[] buf = new char[512];
        int len = 0;
        StringBuffer contentBuffer = new StringBuffer();
        while ((len = reader.read(buf)) != -1) {
            contentBuffer.append(buf, 0, len);
        }
        String content = contentBuffer.toString();
        if(content == null){
            content = "";
        }
        return formToJson(content);

    }
    private static User formToJson(String content){
        String[] strs=content.split("&");

        User user=new User();
        for(String temp:strs){
            String[] data=temp.split("=");
            if(data[0].equals("user")){
                user.setUsername(data[1]);
            }
            if(data[0].equals("pass")){
                user.setPassword(data[1]);
            }
        }
        return user;
    }
}
