/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.crudface;

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
import java.util.Iterator;


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
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>CRUD</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2 >*** DELETE USER ***</h2>\n" +
                "<form action='"+req.getContextPath()+"/delete' method = 'post'>\n" +
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
