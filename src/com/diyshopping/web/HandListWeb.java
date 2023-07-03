package com.diyshopping.web;

import com.diyshopping.dao.HandleDao;
import com.diyshopping.pojo.Handle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/back/handle")
public class HandListWeb extends HttpServlet {
    private HandleDao dao=new HandleDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //列表显示
        ArrayList<Handle> all =dao.getAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("/back/handlelist.jsp").forward(req,resp);


    }
}
