/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.controllers;

import com.google.gson.JsonObject;
import ru.szhernovoy.mod.DBManager;
import ru.szhernovoy.mod.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdate extends javax.servlet.http.HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("email"), req.getParameter("login"), System.currentTimeMillis(),req.getParameter("password"));
        user.setCity_id(Integer.valueOf(req.getParameter("city")));
        user.setCountry_id(Integer.valueOf(req.getParameter("country")));
        DBManager.newInstance().updateItem(user);
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("successUpdate",true);
        out.append(jsonObject.toString());
        out.flush();
    }

}
