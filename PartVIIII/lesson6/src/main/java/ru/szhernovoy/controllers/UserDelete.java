/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.controllers;

import ru.szhernovoy.model.DBManager;
import ru.szhernovoy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserDelete extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.newInstance().deleteUser(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis(),null));
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",DBManager.newInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/views/Delete.jsp").forward(req,resp);
    }
}
