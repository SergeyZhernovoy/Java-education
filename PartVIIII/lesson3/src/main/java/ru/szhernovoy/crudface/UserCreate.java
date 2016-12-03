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

import ru.szhernovoy.dbase.*;



public class UserCreate extends javax.servlet.http.HttpServlet {

    private final static Logger Log = LoggerFactory.getLogger(UserCreate.class);
/*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DBManager.instance().addUser(new User(req.getParameter("email"), req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis()));

    }*/
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
    printWriter.append("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<p> Add user \n" +
            "<body>\n" +
            "\n" +
            "</body>\n" +
            "</html>");

    printWriter.flush();
}
}