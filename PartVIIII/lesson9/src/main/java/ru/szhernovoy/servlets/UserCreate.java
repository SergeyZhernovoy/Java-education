/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.servlets;

import com.google.gson.JsonObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserCreate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*    User user = new User(req.getParameter("email"), req.getParameter("login"), System.currentTimeMillis(),req.getParameter("password"));
        user.setCity_id(Integer.valueOf(req.getParameter("city")));
        user.setCountry_id(Integer.valueOf(req.getParameter("country")));
        DBManager.newInstance().addUser(user);
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("successCreate",true);
        out.append(jsonObject.toString());
        out.flush();*/
    }

}
