package ru.szhernovoy.controllers;


import com.google.gson.JsonObject;
import ru.szhernovoy.model.DBManager;
import ru.szhernovoy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 11.12.2016.
 */
public class SigninController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = DBManager.newInstance().isCredential(login,password);
        JsonObject json = new JsonObject();
        boolean result = false;
        if(user!=null){
            HttpSession session = req.getSession(false);
            session.setAttribute("login",login);
            session.setAttribute("root",user.getRole().getRoot());
            session.setAttribute("user",user);
            result = true;
        }
        json.addProperty("isValid",result);
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.append(json.getAsString());
    }


}
