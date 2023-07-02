package com.neuedu.web;

import com.diyshopping.Table.User;
import com.diyshopping.dao.Userdao;
import com.diyshopping.Table.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/doUpdate")
public class DoUpdate extends HttpServlet {
    private Userdao dao = new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);

        int update = dao.update(user);
        if (update>0){
            resp.sendRedirect("/back/list");
        }else{
            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
        }

    }
}
