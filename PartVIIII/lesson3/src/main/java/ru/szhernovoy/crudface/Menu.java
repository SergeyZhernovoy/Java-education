package ru.szhernovoy.crudface;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.HtmlTable;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by admin on 02.12.2016.
 */
public class Menu extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(Menu.class);


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
                            "<h2 >*** MENU ***</h2>\n" +
                            "<ol>\n"+
                                "<li><a href='"+req.getContextPath()+"/create' >Add user </a></li>\n"+
                                "<li><a href='"+req.getContextPath()+"/update'>Update user</a></li>\n"+
                                "<li><a href='"+req.getContextPath()+"/delete'>Delete user</a></li>\n"+
                            "</ol>\n"+
                            "<h3 >*** list users from dbase ***</h2>\n" +
                            HtmlTable.getInstance().getUsers()+
                            "</body>\n" +
                            "</html>");
                            printWriter.flush();
    }


}
