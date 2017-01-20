package ru.szhernovoy.carstore;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.BodyDBManager;
import ru.szhernovoy.carstore.model.Body;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 20.01.2017.
 */
public class CarTest {
    private final static Logger log = LoggerFactory.getLogger(CarTest.class);


    @Test
    public void whenNeedConvertPOJOToJsonWeGetStringForResponceToWeb(){

        Body body = new Body();
        body.setName("Rtyu");
        body.setCharact("1");
        body.setCharact("2");
        body.setId(1);

        Item item = new Item();
        item.id = 1;
        item.name  = "test";
        body.setItem(item);


        Body two = new Body();
        two.setName("Rtyu");
        two.setCharact("1");
        two.setCharact("2");
        two.setId(1);
     //   two.setItem(item);

        List<Body> bodies = new ArrayList<>();
        bodies.add(body);
        bodies.add(two);


        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bodies);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);




    }



    private class Body{
        private String name;
        private int id;
        List<String> charact = new ArrayList<>();

        private Item item;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getCharact() {
            return charact;
        }

        public void setCharact(String mess) {
            this.charact.add(mess);
        }
    }

    private class Item{
        int id;
        String name;
    }



}
