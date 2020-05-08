package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entities.Quote;
import com.service.QuotePasser;
import com.service.QuotePasserImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "MainQuoteServlet",urlPatterns = "/quote")
public class MainQuoteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        //此打印流对象可向浏览器输出信息
        QuotePasserImpl quotePasser=QuotePasserImpl.getInstance();
        Quote quote=null;
        try {
            quote=quotePasser.passQuote();
        } catch (SQLException throwables) {
            //向日志输出
            throwables.printStackTrace();
        }
        System.out.println(quote);
        //向外部写出
        System.out.println(JSON.toJSONString(quote));
        out.write(JSON.toJSONString(quote));
        out.flush();

    }
}