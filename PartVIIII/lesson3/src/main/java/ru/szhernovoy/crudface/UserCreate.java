/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.crudface;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import ru.szhernovoy.dbase.*;



public class UserCreate extends javax.servlet.http.HttpServlet {

    private final static Logger Log = LoggerFactory.getLogger(UserCreate.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DBManager.instance().addUser(new User(req.getParameter("email"), req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis()));

    }
}