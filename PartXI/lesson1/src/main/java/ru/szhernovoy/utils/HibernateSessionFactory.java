package ru.szhernovoy.utils;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class HibernateSessionFactory {

    /**
     * Created by admin on 10.01.2017.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSessionFactory.class);

    /**
     * Created by admin on 10.01.2017.
     */
    private static SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Created by admin on 10.01.2017.
     * @return SessionFactory
     */
    protected static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);

            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
        return sessionFactory;
    }


    /**
     * Created by admin on 10.01.2017.
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Created by admin on 10.01.2017.
     */
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }


}
