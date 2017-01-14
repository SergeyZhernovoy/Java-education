package ru.szhernovoy.carstore.dao;/**
 * Created by szhernovoy on 14.01.2017.
 */

import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Image;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class ImageDBManager implements DAOInterface<Image> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageDBManager.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param image .
     * @return T
     */
    @Override
    public Image create(Image image) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(image);
        session.getTransaction().commit();
        return image;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param image .
     * @return T
     */
    @Override
    public Image update(Image image) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param image .
     * @return boolean
     */
    @Override
    public boolean delete(Image image) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Image> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Image> get() {
        return null;
    }
}
