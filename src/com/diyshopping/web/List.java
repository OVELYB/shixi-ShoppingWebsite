package com.diyshopping.web;


import com.diyshopping.Table.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/back/list")
public class List extends HttpServlet {
    private Userdao dao= new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User>all =dao.getAll();
        req.setAttribute("all",all);


        req.getRequestDispatcher("/back/list.jsp").forward(req,resp);
    }
}
