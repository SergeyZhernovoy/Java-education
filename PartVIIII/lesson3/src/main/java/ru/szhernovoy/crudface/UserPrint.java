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


public class UserPrint extends javax.servlet.http.HttpServlet {

    private final static Logger Log = LoggerFactory.getLogger(UserPrint.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        Iterator<User> iter = DBManager.instance().getUsers().iterator();
        while(iter.hasNext()){
            printWriter.append(iter.next().toString());
            printWriter.append("\n");
        }
        printWriter.flush();
    }

}