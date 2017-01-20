package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 16.01.2017.
 */


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import ru.szhernovoy.carstore.dao.OrderDBManager;
import ru.szhernovoy.carstore.model.Order;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


public class UpdateOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.getNodeFactory().objectNode();

        HttpSession session = req.getSession(false);
        int orderId = (int)session.getAttribute("currentOrder");
        int userId = -1;
        if(orderId != -1){
            boolean success = (boolean)session.getAttribute("success");
            if(success){
                userId = (int)session.getAttribute("id_user");
            }
            OrderDBManager orderDBManager = new OrderDBManager();
            root.put("orderProperties",orderCollection(orderDBManager.get(orderId)));

        }
        root.put("currentUser",userId);
        root.put("order",orderId);
        out.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int orderId = Integer.valueOf(req.getParameter("order"));
            HttpSession session = req.getSession(false);
            session.setAttribute("currentOrder",orderId);
    }


    public ArrayNode orderCollection(Collection<Order> collection) {
        ArrayNode array = JsonNodeFactory.instance.arrayNode();
        for(Order param : collection){
            ObjectNode obj =  JsonNodeFactory.instance.objectNode();
            obj.put("orderId", param.getId() );
            obj.put("mile", param.getMilesage() );
            obj.put("price", param.getPrice() );
            obj.put("sold", param.getSold() );
            obj.put("carName", param.getCar().getName() );
            obj.put("carId", param.getCar().getId() );
            obj.put("modelId", param.getCar().getModel().getId() );
            obj.put("bodyId", param.getCar().getBody().getId() );
            obj.put("drivetype", param.getCar().getDriveType().getId());
            obj.put("engineId", param.getCar().getEngine().getId() );
            obj.put("transsmId", param.getCar().getTransmission().getId() );
            obj.put("data", param.getRelease().getTime());
            obj.put("userId", param.getUser().getId() );
            array.add(obj);
        }
        return array;
    }

}
