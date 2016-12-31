package ru.szhernovoy.servlets;

import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.Item;
import ru.szhernovoy.service.HibernateSessionFactory;

import java.sql.Timestamp;

/**
 * Created by admin on 30.12.2016.
 */
public class Validation {
    private final static Logger log = LoggerFactory.getLogger(Validation.class);

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Item contactEntity = new Item();

        contactEntity.setCreate(new Timestamp(System.currentTimeMillis()));
        contactEntity.setDesc("first message");
        contactEntity.setDone(false);

        session.save(contactEntity);
        session.getTransaction().commit();

        session.close();


    }


}
