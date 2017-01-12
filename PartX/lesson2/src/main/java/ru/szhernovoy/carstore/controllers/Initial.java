package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 11.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.UserDBManager;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Initial implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Initial.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HibernateSessionFactory.getSessionFactory();
        UserDBManager userDAO = new UserDBManager();
        userDAO.matchRoot();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateSessionFactory.shutdown();
    }


}
