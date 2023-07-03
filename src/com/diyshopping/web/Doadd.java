package com.diyshopping.web;

import com.diyshopping.pojo.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/doadd")
public class Doadd extends HttpServlet {
         Userdao dao=new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        int role= Integer.parseInt(req.getParameter("role"));
        int active= Integer.parseInt(req.getParameter("active"));
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setPhone(phone);
        user.setRole(role);
        user.setActive(active);
        req.setAttribute("user",user);
       System.out.println(user);


        int add=dao.add(user);
        if(add>0)
        {
            resp.sendRedirect("/back/list");
        }
        else
        {   req.setAttribute("msg","添加失败");
            req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
        }

    }
}
