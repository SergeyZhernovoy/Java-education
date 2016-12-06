/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.dbase.DBManager;
import ru.szhernovoy.dbase.HtmlTable;
import ru.szhernovoy.dbase.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserDelete extends javax.servlet.http.HttpServlet {

    private final static Logger Log = LoggerFactory.getLogger(UserDelete.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DBManager.instance().deleteUser(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis()));
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/layout/Delete.jsp").forward(req,resp);
    }
}
