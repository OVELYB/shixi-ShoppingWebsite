package com.diyshopping.web;

import com.diyshopping.Table.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/update")
public class Update extends HttpServlet {
   private Userdao dao=new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // update

        int id = Integer.parseInt(req.getParameter("id"));
//        根据id查询当前的修改的这条数据
        User oneById = dao.getOneById(id);

        req.setAttribute("user",oneById);
        req.getRequestDispatcher("/back/update.jsp").forward(req,resp);


    }
}
