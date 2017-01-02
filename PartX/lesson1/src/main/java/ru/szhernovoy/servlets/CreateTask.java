package ru.szhernovoy.servlets;

import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.Item;
import ru.szhernovoy.service.HibernateSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Created by admin on 30.12.2016.
 */
public class CreateTask  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        Item task = new Item();
        task.setCreate(new Timestamp(System.currentTimeMillis()));
        task.setDesc(req.getParameter("descr"));
        int done = Integer.valueOf(req.getParameter("done"));
        task.setDone(done == 1);
        PrintWriter out = resp.getWriter();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
        JsonObject result  = new JsonObject();
        result.addProperty("successCreate",true);
        out.append(result.toString());
        out.flush();
    }

}
