package ru.szhernovoy.carstore.dao;


import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Order;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;


import javax.persistence.criteria.Root;
import java.util.*;

/**
 * Created by admin on 14.01.2017.
 */
public class OrderDBManager implements DAOInterface<Order>{
    private final static Logger log = LoggerFactory.getLogger(OrderDBManager.class);


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
        session.close();
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
        session.close();
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
        session.close();
        return  tasks;
    }

    public Collection<Order> getOrderByCriteria(Map<String,Integer> parametres ){

        Collection<Order> orders;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Order.class)
        .setFetchMode("car", FetchMode.JOIN)
        .setFetchMode("transmission")        ;
        Set<String> keyByParam = parametres.keySet();

        for (String key : keyByParam) {
            switch (key){
                case "price":
                    cr.add(Restrictions.gt(key,parametres.get(key)));
                    break;
                case "milesage":
                    cr.add(Restrictions.gt(key,parametres.get(key)));
                    break;
                case "car.body.id" :

                    cr.add(Restrictions.eqOrIsNull(key,parametres.get(key)));
                    break;
                case "car.transmission.id" :
                    cr.add(Restrictions.eqOrIsNull(key,parametres.get(key)));
                    break;
            }
        }
        orders = cr.list();
        session.getTransaction().commit();
        session.close();
        return  orders;
    }


}
