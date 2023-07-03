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

@WebServlet("/handle/addhandle")
public class AddHandle extends HttpServlet {
    private HandleDao dao = new HandleDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Handle> handlesByParentId = dao.getHandlesByParentId();
        req.setAttribute("all",handlesByParentId);

        req.getRequestDispatcher("/back/addhandle.jsp").forward(req,resp);
    }
}
