package com.service.util;

import com.entities.Tree;
import com.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class ParseReqToTree {
    public static Tree parseReq(HttpServletRequest req) throws IOException {
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
        System.out.println(content);
        System.out.println(quoteToJson(content).getQuote());
        return quoteToJson(content);


    }
    private static Tree quoteToJson(String content){
       String[] str=content.split("=");
        Tree tree=new Tree();
        for(String temp: str){
            if(!temp.equals("quote")){
               tree.setQuote(temp);
            }
        }
        return tree;
    }
}
