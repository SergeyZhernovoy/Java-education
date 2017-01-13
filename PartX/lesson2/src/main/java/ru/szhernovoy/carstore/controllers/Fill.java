package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 13.01.2017.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.*;
import ru.szhernovoy.carstore.model.*;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;


public class Fill extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=Windows-1251");
        resp.setCharacterEncoding("UTF-8");
        int typeReq = Integer.valueOf(req.getParameter("type"));
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("item", getJsonArray(typeReq));
        out.append(jsonObject.toString());
        out.flush();

    }

    public String getJsonArray(int type){

        JsonArray jsonArray = null;
        switch (type){
            case 1:
                BodyDBManager bodyDBManager = new BodyDBManager();
                jsonArray = bodyDBManager.convert(bodyDBManager.get());
                break;
            case 2:
                ModelDBManager modelDBManager = new ModelDBManager();
                jsonArray = modelDBManager.convert(modelDBManager.get());
                break;
            case 3:
                EngineDBManager engineDBManager = new EngineDBManager();
                jsonArray = engineDBManager.convert(engineDBManager.get());
                break;
            case 4:
                DriveDBManager driveDBManager = new DriveDBManager();
                jsonArray = driveDBManager.convert(driveDBManager.get());
                break;
            case 5:
                TranssmDBManger transsmDBManger = new TranssmDBManger();
                jsonArray = transsmDBManger.convert(transsmDBManger.get());
                break;
        }

        return jsonArray.toString();

    }

}

