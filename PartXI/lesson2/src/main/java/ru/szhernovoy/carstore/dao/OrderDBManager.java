package ru.szhernovoy.carstore.dao;


import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.carstore.model.Body;
import ru.szhernovoy.carstore.model.Car;
import ru.szhernovoy.carstore.model.Order;
import ru.szhernovoy.carstore.model.Transmission;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
        CriteriaBuilder criteriaBuilder =  session.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> orderRoot = criteriaQuery.from(Order.class);
        Join<Order,Car> orderCar = null;
        if(parametres.containsKey("body") || parametres.containsKey("transmission")){
            orderCar = orderRoot.join("car",JoinType.LEFT);
        }

        Set<String> keyByParam = parametres.keySet();
        Predicate criteria = criteriaBuilder.conjunction();
        for (String key : keyByParam) {
            switch (key){
                case "price":
                    criteria = criteriaBuilder.and(criteria, criteriaBuilder.lt(orderRoot.get(key), parametres.get(key)));
                    break;
                case "milesage":
                    criteria = criteriaBuilder.and(criteria, criteriaBuilder.lt(orderRoot.get(key), parametres.get(key)));
                    break;
                case "body" :
                    Join<Car,Body> carBody =  orderCar.join("body",JoinType.LEFT);
                    criteria = criteriaBuilder.and(criteria, criteriaBuilder.equal(carBody.get("id"), parametres.get(key)));
                    break;
                case "transmission" :
                    Join<Car,Transmission> carTransmission = orderCar.join("transmission",JoinType.LEFT);
                    criteria = criteriaBuilder.and(criteria, criteriaBuilder.equal(carTransmission.get("id"), parametres.get(key)));
                    break;
            }
        }
        criteriaQuery.where(criteria);
        orders = session.createQuery(criteriaQuery).list();
        session.getTransaction().commit();
        session.close();
        return  orders;
    }

}
