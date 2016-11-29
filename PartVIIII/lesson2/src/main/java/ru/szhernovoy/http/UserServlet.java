package ru.szhernovoy.http;


import com.mchange.v2.c3p0.*;
import ru.szhernovoy.dbase.DBManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 26.11.2016.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {

    private PooledDataSource pool;


    @Override
    public void init() throws ServletException {

        InitialContext ic = null;
        try {
            ic = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/crud");
            if ( ds instanceof PooledDataSource) {
                this.pool = (PooledDataSource) ds;
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("hello world.");
        printWriter.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
