package ru.szhernovoy.carstore.dao;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.carstore.model.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Admin on 25.01.2017.
 */
public class CarPartyDBManagerTest {
    @Test
    public void whenWeCreatePartyCarWeMustGetId() throws Exception {
        Model model = new Model();
        Transmission transmission = new Transmission();
        Body body = new Body();
        Engine engine = new Engine();
        DriveType driveType = new DriveType();

        model.setName("test model");
        transmission.setName("test transmission");
        body.setName("test bosy");
        engine.setName("test engine");
        driveType.setName("test drive");
        model = new ModelDBManager().create(model);

        body =  new BodyDBManager().create(body);
        transmission = new TranssmDBManger().create(transmission);
        engine = new EngineDBManager().create(engine);
        driveType = new DriveDBManager().create(driveType);

        int id = 1;


        Car car = new Car();
        car.setName("test car");
        car.setBody(body);
        car.setDriveType(driveType);
        car.setEngine(engine);
        car.setModel(model);
        car.setTransmission(transmission);

        car = new CarDBManager().create(car);


        Assert.assertThat(id,is(model.getId()));
        Assert.assertThat(id,is(body.getId()));
        Assert.assertThat(id,is(transmission.getId()));
        Assert.assertThat(id,is(driveType.getId()));
        Assert.assertThat(id,is(engine.getId()));
        Assert.assertThat(id,is(car.getId()));

    }
}