/**
 * Created by szhernovoy on 02.12.2016.
 */
package ru.szhernovoy.servlets;

import com.google.gson.JsonObject;
import ru.szhernovoy.dao.value.User;
import ru.szhernovoy.repository.UserRepository;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserCreate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository();
        boolean result = userRepository.createUserReferences(req.getParameter("name"),req.getParameter("name"),req.getParameter("name"),req.getParameter("name")) > 0 ? true : false;
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("successCreate",result);
        out.append(jsonObject.toString());
        out.flush();
    }

}
