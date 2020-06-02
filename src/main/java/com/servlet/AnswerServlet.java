package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entities.Answer;
import com.service.AnswerPasserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AnswerServlet",urlPatterns = "/answer")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Answer answer=null;
        AnswerPasserImpl answerPasser=AnswerPasserImpl.getInstance();
        try {
           answer=answerPasser.passAnswer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        System.out.println(answer);
        System.out.println(JSON.toJSONString(answer));
        out.write(JSON.toJSONString(answer));
        super.service(req, resp);
    }
}
