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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DBManager.instance().addUser(new User(req.getParameter("email"), req.getParameter("name"), req.getParameter("login"), System.currentTimeMillis()));
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>CRUD</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2 >*** CREATE USER ***</h2>\n" +
                "<form action='"+req.getContextPath()+"/create' method = 'post'>\n" +
                "name:<br>\n" +
                "<input type='text' name='name' ><br>\n" +
                "login:<br>\n" +
                "<input type='text' name='login'><br>\n" +
                "email:<br>\n" +
                "<input type='text' name='email'>\n" +
                "<br><br>\n" +
                "<input style='left: auto' type='submit'>\n" +
                "</form>\n" +
                "<p><a href='"+req.getContextPath()+"/menu'>back to menu...</a>\n"+
                "<h3 >*** list users from dbase ***</h2>\n" +
                HtmlTable.getInstance().getUsers()+
                "</body>\n" +
                "</html>");
        printWriter.flush();
    }
}
//