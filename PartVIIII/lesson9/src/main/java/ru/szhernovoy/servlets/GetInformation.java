package ru.szhernovoy.servlets;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.dao.value.*;
import ru.szhernovoy.repository.RoleRepository;
import ru.szhernovoy.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by admin on 22.12.2016.
 */
public class GetInformation extends HttpServlet {
    private final static Logger log = LoggerFactory.getLogger(GetInformation.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");

        String  address =req.getParameter("address");
        String  music =req.getParameter("music");
        String  role =req.getParameter("role");
        String  roleAll =req.getParameter("roleAll");

        PrintWriter out = new PrintWriter(resp.getOutputStream());
        JsonObject jsonObject = new JsonObject();

        boolean isSetProperty =false;

        if(!address.isEmpty()&& !isSetProperty){
           jsonObject.addProperty("user",getAddres(address).toString());
            isSetProperty = true;
        }
        if(!music.isEmpty()&& !isSetProperty){
           jsonObject.addProperty("user",getMusic(music).toString());
            isSetProperty = true;
        }
        if(!role.isEmpty() && !isSetProperty){
           jsonObject.addProperty("user",getRole(role).toString());
            isSetProperty = true;
        }
        if(!roleAll.isEmpty() && !isSetProperty){
           jsonObject.addProperty("user",getAllRole().toString());
        }
        out.append(jsonObject.toString());
        out.flush();
    }

    public JsonArray getAddres(String address){

        UserRepository userRepository = new UserRepository();
        Address newAddress = new Address();
        newAddress.setName(address);
        Collection<UserRepository.UserReferences> users = userRepository.getUserReferences(newAddress);
        JsonArray array = new JsonArray();
        for (UserRepository.UserReferences userReferences : users){
             JsonObject obj = new JsonObject();
             obj.addProperty("login",userReferences.getUser().getName());
             obj.addProperty("address",userReferences.getAddress().getName());
             obj.addProperty("role",userReferences.getRole().getName());
             array.add(obj);
        }
        return array;
    }

    public JsonArray getMusic(String music){
        UserRepository userRepository = new UserRepository();
        MusicType newMusic = new MusicType();
        newMusic.setName(music);
        Collection<UserRepository.UserReferences> users = userRepository.getUserReferences(newMusic);
        JsonArray array = new JsonArray();
        for (UserRepository.UserReferences userReferences : users){
            JsonObject obj = new JsonObject();
            obj.addProperty("login",userReferences.getUser().getName());
            obj.addProperty("address",userReferences.getAddress().getName());
            obj.addProperty("role",userReferences.getRole().getName());
            array.add(obj);
        }
        return array;
    }

    public JsonArray getRole(String role){
        UserRepository userRepository = new UserRepository();
        Role newRole = new Role();
        newRole.setName(role);
        Collection<UserRepository.UserReferences> users = userRepository.getUserReferences(newRole);
        JsonArray array = new JsonArray();
        for (UserRepository.UserReferences userReferences : users){
            JsonObject obj = new JsonObject();
            obj.addProperty("login",userReferences.getUser().getName());
            obj.addProperty("address",userReferences.getAddress().getName());
            obj.addProperty("role",userReferences.getRole().getName());
            array.add(obj);
        }
        return array;
    }

    public JsonArray getAllRole(){
        RoleRepository roleRepository = new RoleRepository();
        Collection<User> users = roleRepository.getRoleReferences();
        JsonArray array = new JsonArray();
        for (User user : users){
            JsonObject obj = new JsonObject();
            obj.addProperty("login",user.getName());
            obj.addProperty("address",user.getAdressId());
            obj.addProperty("role",user.getRoleId());
            array.add(obj);
        }
        return array;
    }

}

