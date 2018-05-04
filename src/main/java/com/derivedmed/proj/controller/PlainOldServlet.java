package com.derivedmed.proj.controller;

import com.derivedmed.proj.factory.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlainOldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/main.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProxyService<UserService> userService = new ProxyService<>(UserServiceImpl.getInstance());
//        userService.getProxy().createUser(req,resp);
        ServiceFactory.getInstance().getUserService().createUser(req,resp);
    }
}
