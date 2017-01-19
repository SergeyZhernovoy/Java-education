package ru.szhernovoy.carstore.dao;/**
 * Created by szhernovoy on 13.01.2017.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Transmission;
import ru.szhernovoy.carstore.utilite.HibernateSessionFactory;

import java.util.Collection;


public class TranssmDBManger implements DAOInterface<Transmission> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranssmDBManger.class);

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return T
     */
    @Override
    public Transmission create(Transmission transmission) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return T
     */
    @Override
    public Transmission update(Transmission transmission) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param transmission .
     * @return boolean
     */
    @Override
    public boolean delete(Transmission transmission) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Transmission> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Transmission> get() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "from ru.szhernovoy.carstore.model.Transmission";
        Collection<Transmission> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        return  tasks;
    }

    public JsonArray convert(Collection<Transmission> collection) {
        JsonArray array = new JsonArray();
        for(Transmission param : collection){
            JsonObject obj = new JsonObject();
            obj.addProperty("id", param.getId() );
            obj.addProperty("name", param.getName());
            array.add(obj);
        }
        return array;
    }
}
