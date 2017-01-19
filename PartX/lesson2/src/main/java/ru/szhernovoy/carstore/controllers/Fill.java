package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 13.01.2017.
 */

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.*;
import ru.szhernovoy.carstore.utilite.JsonController;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Fill extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fill.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int typeReq = Integer.valueOf(req.getParameter("type"));
        PrintWriter out = resp.getWriter();
        out.append(getCollectionInJson(typeReq));
        out.flush();

    }

    public String getCollectionInJson(int type){

        ObjectNode root  = JsonNodeFactory.instance.objectNode();
        ArrayNode jsonArray = JsonNodeFactory.instance.arrayNode();

        switch (type){
            case 1:
                jsonArray = JsonController.getInstance().convert(new BodyDBManager().get());
                break;
            case 2:
             //   jsonArray = JsonController.getInstance().convert(new ModelDBManager().get());
                break;
            case 3:
             //   jsonArray = JsonController.getInstance().convert(new EngineDBManager().get());
                break;
            case 4:
            //    jsonArray = JsonController.getInstance().convert(new DriveDBManager().get());
                break;
            case 5:
             //   jsonArray = JsonController.getInstance().convert(new TranssmDBManger().get());
                break;
        }

        root.put("item",jsonArray);
        return root.toString();

    }

}

