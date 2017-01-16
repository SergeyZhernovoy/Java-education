package ru.szhernovoy.carstore.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Order;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

/**
 * Created by admin on 14.01.2017.
 */
public class OrderDBManager implements DAOInterface<Order>, JsonConvert<Order> {
    private final static Logger log = LoggerFactory.getLogger(OrderDBManager.class);


    @Override
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


    public JsonArray convertWithField(Collection<Order> collection) {
        JsonArray array = new JsonArray();
        for(Order param : collection){
            JsonObject obj = new JsonObject();
            obj.addProperty("orderId", param.getId() );
            obj.addProperty("mile", param.getMilesage() );
            obj.addProperty("price", param.getPrice() );
            obj.addProperty("sold", param.getSold() );
            obj.addProperty("carName", param.getCar().getName() );
            obj.addProperty("carId", param.getCar().getId() );
            obj.addProperty("modelId", param.getCar().getModel().getId() );
            obj.addProperty("bodyId", param.getCar().getBody().getId() );
            obj.addProperty("drivetype", param.getCar().getDriveType().getId());
            obj.addProperty("engineId", param.getCar().getEngine().getId() );
            obj.addProperty("transsmId", param.getCar().getTransmission().getId() );
            obj.addProperty("data", param.getRelease().getTime());
            obj.addProperty("userId", param.getUser().getId() );
            array.add(obj);
        }
        return array;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param order .
     * @return T
     */
    @Override
    public Order create(Order order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        return order;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param order .
     * @return T
     */
    @Override
    public Order update(Order order) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param order .
     * @return boolean
     */
    @Override
    public boolean delete(Order order) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Order> get(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Collection<Order> orders = session.createQuery(String.format("from ru.szhernovoy.carstore.model.Order as order where order.id = %d",id)).list();
        session.getTransaction().commit();
        return orders;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Order> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Order";
        Collection<Order> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        return  tasks;
    }
}
