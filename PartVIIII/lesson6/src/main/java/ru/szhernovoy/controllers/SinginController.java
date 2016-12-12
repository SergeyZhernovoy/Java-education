package ru.szhernovoy.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.DBManager;
import ru.szhernovoy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 11.12.2016.
 */
public class SinginController extends HttpServlet{

    private final static Logger log = LoggerFactory.getLogger(SinginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = DBManager.instance().isCredential(login,password);
        if(user!=null){
            HttpSession session = req.getSession(false);
            synchronized (session){
                req.setAttribute("login",login);
                req.setAttribute("root",user.getRole().getRoot());
                req.setAttribute("user",user);
            }
           resp.sendRedirect(String.format("%s/",req.getContextPath()));
        }else{
            req.setAttribute("error","Credentional invalid");
            doGet(req,resp);
        }
    }


}
