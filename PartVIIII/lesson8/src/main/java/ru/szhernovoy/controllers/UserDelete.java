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
import java.io.IOException;
import java.io.PrintWriter;


public class UserDelete extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.newInstance().deleteUser( new User(null, req.getParameter("login"), System.currentTimeMillis(),null));
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("successDelete",true);
        out.append(jsonObject.toString());
    }
}
