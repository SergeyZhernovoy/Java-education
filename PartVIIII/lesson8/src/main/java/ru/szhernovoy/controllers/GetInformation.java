package ru.szhernovoy.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.mod.DBManager;
import ru.szhernovoy.mod.User;

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
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        JsonObject jsonObject = new JsonObject();
        if(country){
           jsonObject.addProperty("country",getCountry().toString());
        }
        if(city){
           jsonObject.addProperty("city",getCity().toString());
        }
        if(login){
           jsonObject.addProperty("login",getLogin().toString());
        }
        if(user){
           jsonObject.addProperty("user",getUsers().toString());
        }
        out.append(jsonObject.toString());
        out.flush();
    }

    public JsonArray getCountry(){
        Map<Integer,String> country = DBManager.newInstance().getCityOrCountry(1);
        JsonArray array = new JsonArray();
        Set<Integer> keys = country.keySet();
        for (Integer key : keys){
             JsonObject obj = new JsonObject();
             obj.addProperty("id",key);
             obj.addProperty("name",country.get(key));
             array.add(obj);
        }
        return array;
    }

    public JsonArray getCity(){
        Map<Integer,String> city = DBManager.newInstance().getCityOrCountry(2);
        JsonArray array = new JsonArray();
        Set<Integer> keys = city.keySet();
        for (Integer key : keys){
            JsonObject obj = new JsonObject();
            obj.addProperty("id",key);
            obj.addProperty("name",city.get(key));
            array.add(obj);
        }
        return array;
    }

    public JsonArray getLogin(){
        JsonArray array = new JsonArray();
        for(User user : DBManager.newInstance().getUsers()){
           JsonObject obj = new JsonObject();
           obj.addProperty("log",user.getLogin());
           array.add(obj);
        }
        return array;
    }

    public JsonArray getUsers(){
        JsonArray array = new JsonArray();
        for(User user : DBManager.newInstance().getUsers()){
            JsonObject obj = new JsonObject();
            obj.addProperty("login",user.getLogin());
            obj.addProperty("email",user.getEmail());
            obj.addProperty("city",user.getNameCity());
            obj.addProperty("country",user.getNameCountry());
            obj.addProperty("date",user.getCreateDate().toString());
            obj.addProperty("password",user.getPassword());
            array.add(obj);
        }
        return array;
    }

}

