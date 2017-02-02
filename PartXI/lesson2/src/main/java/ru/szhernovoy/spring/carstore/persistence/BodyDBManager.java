package ru.szhernovoy.spring.carstore.persistence;/**
 * Created by szhernovoy on 13.01.2017.
 */

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.spring.carstore.domain.Body;
import ru.szhernovoy.spring.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class BodyDBManager implements DAOInterface<Body>{

    private static final Logger LOGGER = LoggerFactory.getLogger(BodyDBManager.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param body .
     * @return T
     */
    @Override
    public Body create(Body body) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(body);
        session.getTransaction().commit();
        session.close();
        return body;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param body .
     * @return T
     */
    @Override
    public Body update(Body body) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param body .
     * @return boolean
     */
    @Override
    public boolean delete(Body body) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Body> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Body> get() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Body";
        Collection<Body> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return  tasks;
    }


}
