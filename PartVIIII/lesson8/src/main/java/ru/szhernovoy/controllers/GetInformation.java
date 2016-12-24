package ru.szhernovoy.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.mod.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 22.12.2016.
 */
public class GetInformation extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(GetInformation.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean country = Boolean.valueOf(req.getParameter("country"));
        boolean city = Boolean.valueOf(req.getParameter("city"));
        boolean login = Boolean.valueOf(req.getParameter("login"));
        boolean user = Boolean.valueOf(req.getParameter("user"));
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if(country){
            out.append(getCountry());
        }
        if(city){
            out.append(getCity());
        }
        if(login){
            out.append(getLogin());
        }
        if(user){
            out.append(getUser());
        }
        out.flush();
    }

    public String getCountry(){

        Map<Integer,String> country = DBManager.newInstance().getCityOrCountry(1);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("country",new Gson().toJson(country));
        return jsonObject.toString();

    }

    public String getCity(){
        Map<Integer,String> city = DBManager.newInstance().getCityOrCountry(2);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("city",new Gson().toJson(city));
        return jsonObject.toString();
    }

    public String getLogin(){
        JsonObject json = new JsonObject();
        return json.toString();
    }

    public String getUser(){
        JsonObject json = new JsonObject();
        return json.toString();
    }

}

