package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 13.01.2017.
 */

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.*;

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

        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            switch (type){
                case 1:
                    result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new BodyDBManager().get());
                    break;
                case 2:
                    result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ModelDBManager().get());
                    break;
                case 3:
                    result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new EngineDBManager().get());
                    break;
                case 4:
                    result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new DriveDBManager().get());
                    break;
                case 5:
                    result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new TranssmDBManger().get());
                    break;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }
        return result;
    }

}

