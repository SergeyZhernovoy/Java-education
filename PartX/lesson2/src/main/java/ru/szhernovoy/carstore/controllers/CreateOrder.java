package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 12.01.2017.
 */


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.BooleanNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NumericNode;
import org.codehaus.jackson.node.ObjectNode;
import org.hibernate.Session;
import ru.szhernovoy.carstore.dao.CarDBManager;
import ru.szhernovoy.carstore.dao.OrderDBManager;
import ru.szhernovoy.carstore.model.*;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

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

        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        Integer userId = (int)session.getAttribute("id_user");
        int orderId = (int)session.getAttribute("currentOrder");
        if(userId != -1) {
            //orderId = Integer.valueOf(req.getParameter("orderId"));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            try {
                timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("release")).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Car newCar =   mapper.readValue((String) req.getParameter("car"), Car.class);
            int carId = Integer.valueOf(req.getParameter("carId"));
            if( carId!= -1){
                newCar.setId(carId);
            }
            newCar = new CarDBManager().create(newCar);

            User user = new User();
            user.setId(userId);

            Order order = mapper.readValue((String) req.getParameter("order"), Order.class);
            order.setCar(newCar);
            order.setRelease(timestamp);
            order.setUser(user);
            if (orderId != -1){
                order.setId(orderId);
            }
            orderId = new OrderDBManager().create(order).getId();
            session.setAttribute("currentOrder",orderId);
        }
        out.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(JsonNodeFactory.instance.numberNode(orderId)));
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
