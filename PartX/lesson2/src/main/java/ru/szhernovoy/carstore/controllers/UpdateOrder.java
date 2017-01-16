package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 16.01.2017.
 */

import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.OrderDBManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class UpdateOrder extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateOrder.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=Windows-1251");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        HttpSession session = req.getSession(false);
        int orderId = (int)session.getAttribute("currentOrder");
        int userId = -1;
        if(orderId != -1){
            boolean success = (boolean)session.getAttribute("success");
            if(success){
                userId = (int)session.getAttribute("id_user");
            }
            OrderDBManager orderDBManager = new OrderDBManager();
            jsonObject.addProperty("orderProperties",orderDBManager.convertWithField(orderDBManager.get(orderId)).toString());

        }
        jsonObject.addProperty("currentUser",userId);
        jsonObject.addProperty("order",orderId);
        out.append(jsonObject.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int orderId = Integer.valueOf(req.getParameter("order"));
            HttpSession session = req.getSession(false);
            session.setAttribute("currentOrder",orderId);
    }

}
