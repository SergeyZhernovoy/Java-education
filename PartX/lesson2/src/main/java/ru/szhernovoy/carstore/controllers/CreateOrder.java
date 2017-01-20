package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 12.01.2017.
 */


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.szhernovoy.carstore.dao.CarDBManager;
import ru.szhernovoy.carstore.dao.OrderDBManager;
import ru.szhernovoy.carstore.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

public class CreateOrder extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();

        HttpSession session = req.getSession(false);
        Integer userId = (int)session.getAttribute("id_user");
        int orderId = (int)session.getAttribute("currentOrder");
        if(userId != -1) {


            String name = req.getParameter("name");
            int modelId = Integer.valueOf(req.getParameter("model"));
            int bodyId = Integer.valueOf(req.getParameter("body"));
            int transsmId = Integer.valueOf(req.getParameter("transsmission"));
            int driveId = Integer.valueOf(req.getParameter("drivetype"));
            int engineId = Integer.valueOf(req.getParameter("engine"));
            int price = Integer.valueOf(req.getParameter("price"));
            int mileage = Integer.valueOf(req.getParameter("mile"));
            int carId = Integer.valueOf(req.getParameter("carId"));
            boolean sold = Boolean.valueOf(req.getParameter("sold"));


            //orderId = Integer.valueOf(req.getParameter("orderId"));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            try {
                timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("release")).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Car newCar = new Car(name,modelId,bodyId,driveId,transsmId,engineId);
            if(carId != -1){
                newCar.setId(carId);
            }

            newCar = new CarDBManager().create(newCar);

            User user = new User();
            user.setId(userId);

            Order order = new Order();
            order.setCar(newCar);
            order.setPrice(price);
            order.setMilesage(mileage);
            order.setRelease(timestamp);
            order.setUser(user);
            order.setSold(sold);
            if (orderId != -1){
                order.setId(orderId);
            }

            orderId = new OrderDBManager().create(order).getId();
            session.setAttribute("currentOrder",orderId);
        }

        jsonObject.addProperty("order", orderId);
        out.append(jsonObject.toString());
        out.flush();

     }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        HttpSession session = req.getSession(false);
        Integer userId = -1;
        if(session != null){
            boolean success = (boolean)session.getAttribute("success");
            if(success){
                userId = (int)session.getAttribute("id_user");
            }
        }
        OrderDBManager orderDBManager = new OrderDBManager();
        jsonObject.addProperty("currentUser",userId);
        jsonObject.addProperty("orders",convert(orderDBManager.get()).toString());
        out.append(jsonObject.toString());
        out.flush();
    }

    public JsonArray convert(Collection<Order> collection) {
        JsonArray array = new JsonArray();
        for(Order param : collection){
            JsonObject obj = new JsonObject();
            obj.addProperty("orderId", param.getId() );
            obj.addProperty("mile", param.getMilesage() );
            obj.addProperty("price", param.getPrice() );
            if(param.getSold()){
                obj.addProperty("sold", "V" );
            } else {
                obj.addProperty("sold", "" );
            }
            obj.addProperty("carName", param.getCar().getName() );
            obj.addProperty("carId", param.getCar().getId() );

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(param.getRelease().getTime());
            //calendar.get(Calendar.YEAR);

            obj.addProperty("data", String.valueOf(calendar.get(Calendar.YEAR)));
            obj.addProperty("userId", param.getUser().getId() );
            array.add(obj);
        }
        return array;
    }




}
