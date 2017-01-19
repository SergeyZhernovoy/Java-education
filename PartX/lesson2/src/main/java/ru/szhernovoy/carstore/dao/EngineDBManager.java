package ru.szhernovoy.carstore.dao;/**
 * Created by szhernovoy on 13.01.2017.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Engine;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class EngineDBManager implements DAOInterface<Engine>{

    private static final Logger LOGGER = LoggerFactory.getLogger(EngineDBManager.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param engine .
     * @return T
     */
    @Override
    public Engine create(Engine engine) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param engine .
     * @return T
     */
    @Override
    public Engine update(Engine engine) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param engine .
     * @return boolean
     */
    @Override
    public boolean delete(Engine engine) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Engine> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Engine> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Engine";
        Collection<Engine> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        return  tasks;
    }


    public JsonArray convert(Collection<Engine> collection) {
        JsonArray array = new JsonArray();
        for(Engine param : collection){
            JsonObject obj = new JsonObject();
            obj.addProperty("id", param.getId() );
            obj.addProperty("name", param.getName());
            array.add(obj);
        }
        return array;
    }
}
