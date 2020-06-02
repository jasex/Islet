package com.servlet;

import com.entities.Tree;
import com.service.TreePosterImpl;
import com.service.util.ParseReqToTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PostTreeServlet",urlPatterns = "/postTree")
public class PostTreeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        //此打印流对象可向浏览器输出信息
        Tree tree=ParseReqToTree.parseReq(req);
        TreePosterImpl treePoster=TreePosterImpl.getInstance();
        try {
            treePoster.postTree(tree);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
