package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 12.01.2017.
 */


import ru.szhernovoy.carstore.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CreateOrder extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        Integer userId = (int)session.getAttribute("id_user");
        if(userId != null) {
            String name = req.getParameter("name");
            int modelId = Integer.valueOf(req.getParameter("model"));
            int bodyId = Integer.valueOf(req.getParameter("body"));
            int transsmId = Integer.valueOf(req.getParameter("transsmission"));
            int driveId = Integer.valueOf(req.getParameter("drivetype"));
            int engineId = Integer.valueOf(req.getParameter("engine"));

            Car newCar = new Car();
            Body body = new Body();
            DriveType driveType = new DriveType();
            Transmission transmission = new Transmission();
            Model model = new Model();
            Engine engine = new Engine();
            body.setId(bodyId);
            driveType.setId(driveId);
            engine.setId(engineId);
            transmission.setId(transsmId);
            model.setId(modelId);


            newCar.setName(name);
            newCar.setBody(body);
            newCar.setDriveType(driveType);
            newCar.setEngine(engine);
            newCar.setTransmission(transmission);
            newCar.setModel(model);




        }
     }
}
