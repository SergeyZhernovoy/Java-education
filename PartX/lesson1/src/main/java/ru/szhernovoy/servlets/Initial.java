package ru.szhernovoy.servlets;


import ru.szhernovoy.service.HibernateSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created by admin on 02.01.2017.
 */
public class Initial implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateSessionFactory.shutdown();
    }
}
