package com.diyshopping.web;

import com.diyshopping.pojo.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sale/dosaleregister")
public class DoSaleRegisterWeb extends HttpServlet {

        private Userdao dao =new Userdao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        int role = Integer.parseInt(req.getParameter("role"));
        User user = new User();
        user.setEmail(email);
        user.setRole(role);
        user.setUsername(username);
        user.setActive(1);
        user.setPassword(password);
        user.setPhone(phone);
        int add = dao.add(user);
        if(add>0){
//        成功添加后，进行数据的显示  表所有数据，条列表页
            resp.sendRedirect("/back/login");
        }else{
            req.setAttribute("msg","注册失败");
            req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
        }











    }
}
