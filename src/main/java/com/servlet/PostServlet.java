package com.servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "PostServlet",urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        System.out.println(this.getServletContext().getRealPath("/123"));
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> list=upload.parseRequest(req);
            for(FileItem item:list){
                System.out.println(item.getName());
                item.getInputStream();
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
