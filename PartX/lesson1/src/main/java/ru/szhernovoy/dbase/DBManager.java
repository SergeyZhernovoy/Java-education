package ru.szhernovoy.dbase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.hibernate.Session;
import ru.szhernovoy.model.Item;
import ru.szhernovoy.service.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Created by Admin on 07.01.2017.
 */
public class DBManager {
    private final static Logger logger = LoggerFactory.getLogger(HibernateSessionFactory.class);

    public boolean createTask(String description, boolean done){
        boolean result = false;
        try{
            result = true;
            Item task = new Item();
            task.setCreate(new Timestamp(System.currentTimeMillis()));
            task.setDesc(description);
            task.setDone(done);
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        }catch (Throwable exc){
            logger.error(exc.getMessage(),exc);
        }

        return result;
    }

    public String getItemsInJson(boolean all){

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        String query = null;
        if(all){
            query = "from ru.szhernovoy.model.Item";
        }else{
            query = "from ru.szhernovoy.model.Item as i where i.done = false";
        }

        Collection<Item> tasks = session.createQuery(query).list();
        session.getTransaction().commit();
        JsonArray array = new JsonArray();
        Item item = null;
        for (Item task : tasks){
            JsonObject obj = new JsonObject();
            obj.addProperty("descr",task.getDesc());
            obj.addProperty("createDate",task.getCreate().toString());
            obj.addProperty("done",task.getDone() ? "V": "");
            array.add(obj);
        }
        return array.toString();
    }

}
