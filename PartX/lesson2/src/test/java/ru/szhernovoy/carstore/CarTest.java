package ru.szhernovoy.carstore;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.*;

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

        Car car = new Car();
        Body body = new Body();
        DriveType driveType = new DriveType();
        Engine engine = new Engine();
        Transmission transmission = new Transmission();
        Model model = new Model();

        body.setId(1);
        body.setName("test body");
        driveType.setId(1);
        driveType.setName("test drive");
        engine.setId(1);
        engine.setName("test engine");
        transmission.setId(1);
        transmission.setName("test transm");
        model.setId(1);
        model.setName("test model");

        car.setId(1);
        car.setName("test car");
        car.setBody(body);
        car.setDriveType(driveType);
        car.setEngine(engine);
        car.setModel(model);
        car.setTransmission(transmission);

        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);

    }

}
