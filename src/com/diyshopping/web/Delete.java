package com.diyshopping.web;

import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/back/delete")
public class Delete extends HttpServlet {
   private Userdao dao=new Userdao();
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        int delete=dao.delete(id);
        if (delete>0){
            resp.sendRedirect("/back/list");
        }else{
            req.setAttribute("msg","删除失败");
            req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
        }

    }
}
