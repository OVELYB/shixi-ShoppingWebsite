package com.diyshopping.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/adminlist")
public class Adminlist extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException //请求
    {

        req.getRequestDispatcher("/back/adminlist.jsp").forward(req,resp);

        //System.out.println("后台管理员");
    }
}
