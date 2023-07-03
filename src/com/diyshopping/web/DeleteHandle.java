package com.diyshopping.web;

import com.diyshopping.dao.HandleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/deletehandle")
public class DeleteHandle extends HttpServlet {
    private HandleDao dao=new HandleDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));


        int delete=dao.delete(id);
        if (delete>0){
            resp.sendRedirect("/back/handle");
        }else{
            req.setAttribute("msg","删除失败");
            req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
        }
    }
}
