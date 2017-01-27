package ru.szhernovoy.storages;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import ru.szhernovoy.utils.HibernateSessionFactory;

import java.util.Collection;
import java.util.List;

@Component
public class JdbcDAO implements Crud {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDAO.class);

    private JdbcDAO(){
        HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public User add(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public boolean update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public User get(int id) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        Query query = session.createQuery("from ru.szhernovoy.storages.User as u where u.id = :id");
        query.setParameter("id",id);
        user = (User)query.list().get(0);
        session.getTransaction().commit();
        return  user;
    }

    @Override
    public Collection<User> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        List<User> storage = session.createQuery("from ru.szhernovoy.storages.User").list();
        session.getTransaction().commit();
        return  storage;
    }
}
