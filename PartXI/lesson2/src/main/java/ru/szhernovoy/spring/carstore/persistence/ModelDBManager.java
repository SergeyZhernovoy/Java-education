package ru.szhernovoy.spring.carstore.persistence;/**
 * Created by szhernovoy on 13.01.2017.
 */

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.spring.carstore.domain.Model;
import ru.szhernovoy.spring.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class ModelDBManager implements DAOInterface<Model>{

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelDBManager.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param model .
     * @return T
     */
    @Override
    public Model create(Model model) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param model .
     * @return T
     */
    @Override
    public Model update(Model model) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param model .
     * @return boolean
     */
    @Override
    public boolean delete(Model model) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Model> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Model> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Model";
        Collection<Model> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return  tasks;
    }

}
