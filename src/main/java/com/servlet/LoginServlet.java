package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("text/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        //此打印流对象可向浏览器输出信息

        //清理打印流
        out.flush();
        //冲洗
    }
}
