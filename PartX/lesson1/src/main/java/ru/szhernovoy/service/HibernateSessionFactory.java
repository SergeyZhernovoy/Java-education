package ru.szhernovoy.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by admin on 30.12.2016.
 */
public class HibernateSessionFactory {

    /**
     * Created by admin on 30.12.2016.
     * singleton
     */
    private static SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Created by admin on 30.12.2016.
     * create factory
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
     * Created by admin on 30.12.2016.
     * return factory
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Created by admin on 30.12.2016.
     * close factory
     */
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }


}
