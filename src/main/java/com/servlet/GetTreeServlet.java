package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entities.Tree;
import com.service.TreePasserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GetTreeServlet",urlPatterns = "/getTree")
public class GetTreeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tree tree=null;
        TreePasserImpl treePasser=TreePasserImpl.getInstance();
        try {
            tree=treePasser.getRandomTree();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        System.out.println(tree);
        System.out.println(JSON.toJSONString(tree));
        out.write(JSON.toJSONString(tree));
    }
}
