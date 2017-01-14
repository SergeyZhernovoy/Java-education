package ru.szhernovoy.carstore.dao;

import com.google.gson.JsonArray;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Order;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;

/**
 * Created by admin on 14.01.2017.
 */
public class OrderDBManager implements DAOInterface<Order>, JsonConvert<Order> {
    private final static Logger log = LoggerFactory.getLogger(OrderDBManager.class);


    @Override
    public JsonArray convert(Collection<Order> collection) {
        return null;
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
        session.save(order);
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
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Order> get() {
        return null;
    }
}
