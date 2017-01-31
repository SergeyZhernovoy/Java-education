package ru.szhernovoy.carstore.dao;/**
 * Created by szhernovoy on 13.01.2017.
 */

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.szhernovoy.carstore.model.Transmission;
import ru.szhernovoy.carstore.utils.HibernateSessionFactory;

import java.util.Collection;


public class TranssmDBManger implements DAOInterface<Transmission> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranssmDBManger.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return T
     */
    @Override
    public Transmission create(Transmission transmission) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(transmission);
        session.getTransaction().commit();
        session.close();
        return transmission;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return T
     */
    @Override
    public Transmission update(Transmission transmission) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return boolean
     */
    @Override
    public boolean delete(Transmission transmission) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Transmission> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Transmission> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Transmission";
        Collection<Transmission> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return  tasks;
    }

}
