package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entities.Quote;
import com.entities.Relax;
import com.service.QuotePasserImpl;
import com.service.RelaxPasserImpl;
import com.service.util.ParsePics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "RelaxServlet",urlPatterns = "/relax")
public class RelaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        //此打印流对象可向浏览器输出信息
       RelaxPasserImpl relaxPasser=RelaxPasserImpl.getInstance();
        ArrayList<Relax> relaxes=null;
        try {
            relaxes=relaxPasser.passRelax();
        } catch (SQLException throwables) {
            //控制台输出
            throwables.printStackTrace();
        }
        //输出relaxes
        System.out.println(relaxes);
        //向外部写出
        String outputString=ParsePics.parsePic(relaxes);
        out.write(outputString);
        out.flush();
    }
}
