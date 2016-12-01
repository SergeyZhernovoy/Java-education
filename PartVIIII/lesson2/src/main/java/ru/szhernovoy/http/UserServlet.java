package ru.szhernovoy.http;


import com.mchange.v2.c3p0.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.dbase.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by admin on 26.11.2016.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {

    private ComboPooledDataSource pool;
    private final static Logger Log = LoggerFactory.getLogger(UserServlet.class);

    @Override
    public void init() throws ServletException {

        Properties prop = new Properties();
        this.pool = new ComboPooledDataSource();
        try {
            prop.load(new FileInputStream(this.getClass().getClassLoader().getResource("db.properties").getPath()));
        } catch (IOException e) {
            Log.error(e.getMessage(),e);
        }
        try {
            pool.setDriverClass(prop.getProperty("driverClass"));
        } catch (PropertyVetoException e) {
            Log.error(e.getMessage(),e);
        }
        pool.setJdbcUrl(prop.getProperty("jdbcUrl"));
        pool.setUser(prop.getProperty("user"));
        pool.setPassword(prop.getProperty("password"));
        pool.setMaxPoolSize(5);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Connection conn = this.pool.getConnection();
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            Iterator<User>  iter = DBManager.instance().getUsers(conn).iterator();
            while(iter.hasNext()){
                printWriter.append(iter.next().toString());
            }
            printWriter.flush();
        } catch (SQLException e) {
            Log.error(e.getMessage(),e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Connection conn = this.pool.getConnection();
            DBManager.instance().addUser(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis()),conn);
        } catch (SQLException e) {
            Log.error(e.getMessage(),e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Connection conn = this.pool.getConnection();
            DBManager.instance().deleteUser(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis()),conn);
        } catch (SQLException e) {
            Log.error(e.getMessage(),e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Connection conn = this.pool.getConnection();
            DBManager.instance().updateItem(new User(req.getParameter("email"),req.getParameter("name"),req.getParameter("login"),System.currentTimeMillis()),conn);
        } catch (SQLException e) {
            Log.error(e.getMessage(),e);
        }
    }
}
