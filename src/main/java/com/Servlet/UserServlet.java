package com.Servlet;

import dao2.UserDAO;
import pojo2.Collection;
import pojo2.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if ("addcollection".equals(p)) {
            doAddCollection(request, response);
        }
        if ("login".equals(p)) {
            doLogin(request, response);

        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserInfo userInfo = userDAO.login(username, password);
        if (userInfo == null) {
            response.getWriter().println("<script>alert('登录失败');location='login.jsp';</script>");
            return;

        }

        HttpSession session = request.getSession();
        session.setAttribute("userinfo", userInfo);
        response.sendRedirect("goods.do?p=fenye");
    }

    private void doAddCollection(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //判断用户是否已经登录
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userinfo");

        if (userInfo == null) {
            response.getWriter().println("<script>alert('请登录先!');location='login.jsp';</script>");
            return;
        }

        String goodsid = request.getParameter("goodsid");
        String username = userInfo.getUsername();

        List<Collection> list = userDAO.check(username, goodsid);

        if (list.size() > 0) {
            response.getWriter().println("<script>alert('已经收藏!');location='goods.do?p=findbyid&goodsid=" + goodsid + "';</script>");
            return;
        }

        userDAO.addcollection(username, goodsid);
        response.sendRedirect("goods.do?p=findbyid&goodsid=" + goodsid);


    }
}
