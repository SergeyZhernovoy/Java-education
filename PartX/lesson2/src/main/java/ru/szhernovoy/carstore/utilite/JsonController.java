package ru.szhernovoy.carstore.utilite;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Body;

import java.util.Collection;

/**
 * Created by admin on 19.01.2017.
 */
public class JsonController {
    private final static Logger log = LoggerFactory.getLogger(JsonController.class);
    private static JsonController jsonController;

    private JsonController(){

    }

    public static synchronized JsonController getInstance(){
        if(jsonController == null){
            jsonController = new JsonController();
        }
        return jsonController;
    }

    public ArrayNode convert(Collection<Body> collection) {

        ObjectMapper mapper = new ObjectMapper();
    //   mapper.writerWithDefaultPrettyPrinter().
        ArrayNode array = mapper.createArrayNode();
        for(Body param : collection){
            ObjectNode obj = mapper.createObjectNode();
            obj.put("id", param.getId());
            obj.put("name", param.getName());
            array.add(obj);
        }
        return array;
    }


}
