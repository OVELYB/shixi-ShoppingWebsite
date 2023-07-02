package com.diyshopping.web;

import com.diyshopping.Table.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/dologin")
public class dologin extends HttpServlet {
    private Userdao dao=new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        int role= Integer.parseInt(req.getParameter("role"));
        User user = dao.getOneUsernameAndPassword(username, password);
        System.out.println(user);
        if(user.getRole()==role&&user.getRole()==0)
            {
            resp.sendRedirect("/back/adminlist");
            }
        else if(user.getRole()==role&&user.getRole()==1)
            {
                resp.sendRedirect("/back/salelist");
            }
        else
            {
                req.getRequestDispatcher("/back/message.jsp").forward(req,resp);
            }

    }
}
