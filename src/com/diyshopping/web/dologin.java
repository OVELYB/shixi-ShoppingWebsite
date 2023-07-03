package com.diyshopping.web;

import com.diyshopping.pojo.User;
import com.diyshopping.dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/back/dologin")
public class dologin extends HttpServlet {
    private Userdao dao=new Userdao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        int role= Integer.parseInt(req.getParameter("role"));
        System.out.println(password+username+role);
        User user = dao.getOneUsernameAndPassword(username, password);
        System.out.println(user);
        if(user==null){
//            跳到注册页面   注册卖家
            resp.sendRedirect("/sale/register");
        }else{
            if(user.getActive()==0){
                req.setAttribute("msg","注销账号 不能登录");
                req.getRequestDispatcher("/back/fail.jsp").forward(req,resp);
            }else{
                if (user.getRole()==role && user.getRole()==0 ){
//            req.getRequestDispatcher("backList.jsp").forward(req,resp);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    resp.sendRedirect("/back/adminlist");
                }else if(user.getRole()==role && user.getRole()==1){
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    resp.sendRedirect("/sale/salelist");
                }else{
                    req.getRequestDispatcher("/back/message.jsp").forward(req,resp);
                }
            }
        }

    }
}
