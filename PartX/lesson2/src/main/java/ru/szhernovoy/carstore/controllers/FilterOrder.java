package ru.szhernovoy.carstore.controllers;/**
 * Created by Admin on 22.01.2017.
 */




import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import ru.szhernovoy.carstore.dao.OrderDBManager;
import ru.szhernovoy.carstore.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FilterOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        Map<String, Integer> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.getNodeFactory().objectNode();
        try {
            map = mapper.readValue(req.getParameter("filter"),new TypeReference<HashMap<String, Integer>>(){});
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        HttpSession session = req.getSession(false);
        Integer userId = -1;
        if(session != null){
            boolean success = (boolean)session.getAttribute("success");
            if(success){
                userId = (int)session.getAttribute("id_user");
            }
        }
        OrderDBManager orderDBManager = new OrderDBManager();
        root.put("currentUser",userId);
        root.put("orders",convert(orderDBManager.getOrderByCriteria(map)));
        out.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
        out.flush();
    }

    public ArrayNode convert(Collection<Order> collection) {

        ArrayNode array = JsonNodeFactory.instance.arrayNode();
        for(Order param : collection){

            ObjectNode order = JsonNodeFactory.instance.objectNode();
            order.put("orderId", param.getId() );
            order.put("mile", param.getMilesage() );
            order.put("price", param.getPrice() );
            if(param.getSold()){
                order.put("sold", "V" );
            } else {
                order.put("sold", "" );
            }
            order.put("carName", param.getCar().getName() );
            order.put("carId", param.getCar().getId() );

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(param.getRelease().getTime());
            //calendar.get(Calendar.YEAR);

            order.put("data", String.valueOf(calendar.get(Calendar.YEAR)));
            order.put("userId", param.getUser().getId() );
            array.add(order);
        }
        return array;

    }
}
