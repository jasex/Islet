package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entities.Answer;
import com.service.AnswerPasser;
import com.service.AnswerPasserImpl;
import org.apache.log4j.Logger;

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
        //设置输入格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置内容类型为UTF-8
        resp.setContentType("application/json;charset=utf-8");
        //获得打印流对象
        PrintWriter out = resp.getWriter();
        //此打印流对象可向浏览器输出信息
        AnswerPasserImpl answerPasser=AnswerPasserImpl.getInstance();
        Answer answer=null;
        try {
            answer =answerPasser.passAnswer();
        } catch (SQLException throwables) {
            //控制台输出
            throwables.printStackTrace();
        }
        //输出answer
        System.out.println(answer);
        //向外部写出
        System.out.println(JSON.toJSONString(answer));
        out.write(JSON.toJSONString(answer));
        out.flush();

    }
}
