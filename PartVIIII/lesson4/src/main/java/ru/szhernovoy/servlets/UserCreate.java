/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.servlets;

import ru.szhernovoy.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserCreate extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.instance().addUser(new User(req.getParameter("email"), req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis()));

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HtmlTable.getInstance().loadUsers();
        req.getRequestDispatcher("/WEB-INF/layout/Create.jsp").forward(req,resp);
    }
}
//