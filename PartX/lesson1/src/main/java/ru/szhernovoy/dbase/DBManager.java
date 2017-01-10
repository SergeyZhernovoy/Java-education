package ru.szhernovoy.dbase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import ru.szhernovoy.model.Item;
import ru.szhernovoy.service.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.Collection;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Created by Admin on 07.01.2017.
 */
public class DBManager {

    /**
     * Created by admin on 30.12.2016.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSessionFactory.class);

    /**
     * Created by admin on 30.12.2016.
     * @param description .
     * @param done .
     * @return boolean
     */
    public boolean createTask(String description, boolean done) {
        boolean result = false;
        try {
            result = true;
            Item task = new Item();
            task.setCreate(new Timestamp(System.currentTimeMillis()));
            task.setDesc(description);
            task.setDone(done);
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (Throwable exc) {
            LOGGER.error(exc.getMessage(), exc);
        }

        return result;
    }

    /**
     * Created by admin on 30.12.2016.
     * @param all .
     * @return String
     */
    public String getItemsInJson(boolean all) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        String query = null;
        if (all) {
            query = "from ru.szhernovoy.model.Item";
        } else {
            query = "from ru.szhernovoy.model.Item as i where i.done = false";
        }

        Collection<Item> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        JsonArray array = new JsonArray();
        Item item = null;
        for (Item task : tasks) {
            JsonObject obj = new JsonObject();
            obj.addProperty("descr", task.getDesc());
            obj.addProperty("createDate", task.getCreate().toString());
            String done = "";
            if (task.getDone()) {
                done = "V";
            }
            obj.addProperty("done", done);
            array.add(obj);
        }
        return array.toString();
    }

}
