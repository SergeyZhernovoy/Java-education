package ru.szhernovoy.servlets;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import ru.szhernovoy.dbase.DBManager;
import ru.szhernovoy.model.Item;
import ru.szhernovoy.service.HibernateSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Admin on 07.01.2017.
 */
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        DBManager manager = new DBManager();
        PrintWriter out = resp.getWriter();
        JsonObject result  = new JsonObject();
        result.addProperty("successCreate",manager.createTask(req.getParameter("descr"),Boolean.valueOf(req.getParameter("done"))));
        out.append(result.toString());
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=Windows-1251");
        resp.setCharacterEncoding("UTF-8");
        boolean alltasks = Boolean.valueOf(req.getParameter("doneAll"));
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        JsonObject jsonObject = new JsonObject();
        DBManager manager = new DBManager();
        jsonObject.addProperty("tasks",manager.getItemsInJson(alltasks));
        out.append(jsonObject.toString());
        out.flush();
    }

}
