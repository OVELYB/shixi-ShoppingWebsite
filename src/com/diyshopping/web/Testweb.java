package com.diyshopping.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/a")
public class Testweb extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String a ="test data";
       req.setAttribute("data",a);
        System.out.println(1);
        req.getRequestDispatcher("a.jsp").forward(req,resp);
    }
}
