/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.crudface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.dbase.DBManager;
import ru.szhernovoy.dbase.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class UserUpdate extends javax.servlet.http.HttpServlet {

    private final static Logger Log = LoggerFactory.getLogger(UserUpdate.class);

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DBManager.instance().updateItem(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis()));
    }
}