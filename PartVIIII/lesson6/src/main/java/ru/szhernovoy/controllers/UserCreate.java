/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.controllers;

import ru.szhernovoy.model.DBManager;
import ru.szhernovoy.model.Role;
import ru.szhernovoy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserCreate extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("email"), req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis(),req.getParameter("password"));
        Role role = new Role("any");
        role.setId(Integer.valueOf(req.getParameter("role")));
        user.setRole(role);
        DBManager.newInstance().addUser(user);
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",DBManager.newInstance().getUsers());
        req.setAttribute("roles",DBManager.newInstance().getRoles());
        req.getRequestDispatcher("/WEB-INF/views/Create.jsp").forward(req,resp);
        //resp.sendRedirect(String.format("%s/WEB-INF/layout/Create.jsp",req.getContextPath()));
    }
}
