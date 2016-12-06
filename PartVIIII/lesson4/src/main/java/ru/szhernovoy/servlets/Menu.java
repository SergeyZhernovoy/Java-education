package ru.szhernovoy.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.dbase.HtmlTable;

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
        //req.getRequestDispatcher("/webapp/index.jsp").forward(req,resp);
        resp.sendRedirect(String.format("%s/index.jsp",req.getContextPath()));
    }


}
