package ru.szhernovoy.carstore.dao;/**
 * Created by szhernovoy on 13.01.2017.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.DriveType;
import ru.szhernovoy.carstore.model.Model;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class DriveDBManager implements DAOInterface<DriveType>, JsonConvert<DriveType> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriveDBManager.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param driveType .
     * @return T
     */
    @Override
    public DriveType create(DriveType driveType) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param driveType .
     * @return T
     */
    @Override
    public DriveType update(DriveType driveType) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param driveType .
     * @return boolean
     */
    @Override
    public boolean delete(DriveType driveType) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<DriveType> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<DriveType> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.DriveType";
        Collection<DriveType> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        return  tasks;
    }

    @Override
    public JsonArray convert(Collection<DriveType> collection) {
        JsonArray array = new JsonArray();
        for(DriveType param : collection){
            JsonObject obj = new JsonObject();
            obj.addProperty("id", param.getId() );
            obj.addProperty("name", param.getName());
            array.add(obj);
        }
        return array;
    }
}
