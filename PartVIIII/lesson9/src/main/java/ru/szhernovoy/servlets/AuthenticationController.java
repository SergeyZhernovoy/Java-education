package ru.szhernovoy.servlets;


import com.google.gson.JsonObject;
import ru.szhernovoy.dao.factory.DAOFactory;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.value.Role;

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
        String next = String.format("%s/CrudView.html",req.getContextPath());
        DAOFactory factory = DAOFactory.getFactory();
        RoleDAO roleDAO = factory.getRoleDAO();
        Role role = roleDAO.findRoleByName(login);
        roleDAO.close();

        JsonObject json = new JsonObject();
        boolean result = false;
        if(role!=null){
            HttpSession session = req.getSession();
            session.setAttribute("login",login);
            result = true;
        }
        json.addProperty("isValid",result);
        json.addProperty("nextPage",next);
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.append(json.toString());
        out.flush();
    }


}
