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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserUpdate extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String email;
        int id ;
        if(!(Boolean) session.getAttribute("root")){
            email = (String)req.getAttribute("email");
            id = (int)req.getAttribute("role");
        }else {
            email = req.getParameter("email");
            id = Integer.valueOf(req.getParameter("role"));
        }

        User user = new User(email, req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis(),req.getParameter("password"));
        Role role = new Role("any");
        role.setId(id);
        user.setRole(role);
        DBManager.instance().updateItem(user);
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("users",DBManager.instance().getUsers());
        req.setAttribute("roles",DBManager.instance().getRoles());
        HttpSession session = req.getSession(false);
        if(!(Boolean) session.getAttribute("root")){
            req.setAttribute("email",((User)session.getAttribute("user")).getEmail());
            req.setAttribute("role",((User)session.getAttribute("user")).getRole().getId());
        }

        req.getRequestDispatcher("/WEB-INF/views/Update.jsp").forward(req,resp);
    }
}
