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

public class RoleUpdate extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = new Role(req.getParameter("name"));
        String id = req.getParameter("id");
        if(id!=null){
            role.setId(Integer.valueOf(id));
            String root = req.getParameter("root");
            if(root!=null ){
                role.setRoot(root.equals("1")? true : false);
            }
            DBManager.newInstance().updateRole(role);
        }
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles",DBManager.newInstance().getRoles());
        req.getRequestDispatcher("/WEB-INF/views/UpdateRole.jsp").forward(req,resp);
    }
}
