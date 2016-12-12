/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.controllers;

import ru.szhernovoy.model.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RoleCreate extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = new Role(req.getParameter("name"));
        String root = req.getParameter("root");
        if(root!=null){
            role.setRoot(root.equals("1")? true : false);
        }
        DBManager.instance().addRole(role);
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles",DBManager.instance().getRoles());
        req.getRequestDispatcher("/WEB-INF/views/CreateRole.jsp").forward(req,resp);
    }
}
