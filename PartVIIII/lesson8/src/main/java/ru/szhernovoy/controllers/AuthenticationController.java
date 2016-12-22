package ru.szhernovoy.controllers;


import com.google.gson.JsonObject;
import ru.szhernovoy.mod.DBManager;
import ru.szhernovoy.mod.User;

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
public class AuthenticationController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String next = String.format("%s/pages/CrudView.html",req.getContextPath());
        DBManager.newInstance().matcherRoot();
        User user = DBManager.newInstance().isCredential(login,password);
        JsonObject json = new JsonObject();
        boolean result = false;
        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("login",login);
            session.setAttribute("user",user);
            result = true;
        }
        json.addProperty("isValid",result);
        json.addProperty("nextPage",next);
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.append(json.toString());
        out.flush();
    }


}
