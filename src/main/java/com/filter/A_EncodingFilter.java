package com.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter("/*")  // "/*"会拦截所有的资源去解决get/post的乱码问题
//名字前面加A保证该过滤器是第一个运行的
public class A_EncodingFilter implements Filter {

    public A_EncodingFilter() {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");


        // 判断请求类型 (GET/POST)
        String method = request.getMethod();
        // 判断是否是GET请求
        if ("GET".equalsIgnoreCase(method)) {
            // 得到服务器的版本
            String serverInfo = request.getServletContext().getServerInfo(); // Apache Tomcat/8.0.45
            String versionStr =  serverInfo.substring(serverInfo.indexOf("/")+1,serverInfo.indexOf("."));
            if (versionStr != null && Integer.parseInt(versionStr) < 8) {
                // GET请求处理
                HttpServletRequest request2 = new MyWapper(request);
                // 放行资源
                chain.doFilter(request2, response);
                return;
            }

        }

        // 放行资源
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}



class MyWapper extends HttpServletRequestWrapper {

    static final Logger logger=Logger.getLogger(MyWapper.class);
    private HttpServletRequest request;
    public MyWapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }


    @Override
    public String getParameter(String name) {

        String value = null;
        try {
            value = new String(request.getParameter(name).getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return value;
    }



}