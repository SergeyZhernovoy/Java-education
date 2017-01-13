package ru.szhernovoy.carstore.dao;/**
 * Created by Admin on 12.01.2017.
 */

import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.User;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;

public class UserDBManager implements DAOInterface<User> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDBManager.class);

    @Override
    public User create(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public Collection<User> get(int id) {
        return null;
    }

    @Override
    public Collection<User> get() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.User as user";
        Collection<User> users = session.createQuery(query).list();
        session.getTransaction().commit();
        return users;
    }

    public boolean matchUser(String login, String password,User matchUser){

        boolean result = false;
        for (User user : this.get()){
            if (user.getName().equalsIgnoreCase(login) && user.getPassword().equals(password)){
                matchUser = user;
                result = true;
                break;
            }
        }
        return result;
    }


}
