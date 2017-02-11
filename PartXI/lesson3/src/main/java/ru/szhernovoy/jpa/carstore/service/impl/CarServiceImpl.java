package ru.szhernovoy.jpa.carstore.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.szhernovoy.jpa.carstore.domain.*;
import ru.szhernovoy.jpa.carstore.persistance.*;
import ru.szhernovoy.jpa.carstore.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    private CarCrud carCrud;
    private BodyCrud bodyCrud;
    private DriveTypeCrud driveTypeCrud;
    private ModelCrud modelCrud;
    private TranssmCrud transsmCrud;
    private EngineCrud engineCrud;

    @Autowired
    public CarServiceImpl(CarCrud carCrud, BodyCrud bodyCrud, DriveTypeCrud driveTypeCrud, ModelCrud modelCrud, TranssmCrud transsmCrud, EngineCrud engineCrud) {
        this.carCrud = carCrud;
        this.bodyCrud = bodyCrud;
        this.driveTypeCrud = driveTypeCrud;
        this.modelCrud = modelCrud;
        this.transsmCrud = transsmCrud;
        this.engineCrud = engineCrud;
    }

    @Override
    public List<Body> getAllBody() {
        return this.bodyCrud.findByAll();
    }

    @Override
    public Body getBodyById(int id) {
        return this.bodyCrud.findById(id);
    }

    @Override
    public List<Engine> getAllEngine() {
        return this.engineCrud.findByAll();
    }

    @Override
    public Engine getEngineById(int id) {
        return this.engineCrud.findById(id);
    }

    @Override
    public List<DriveType> getAllDriveType() {
        return this.driveTypeCrud.findByAll();
    }

    @Override
    public DriveType getDriveTypeById(int id) {
        return this.driveTypeCrud.findById(id);
    }

    @Override
    public List<Model> getAllModel() {
        return this.modelCrud.findByAll();
    }

    @Override
    public Model getModelById(int id) {
        return this.modelCrud.findById(id);
    }

    @Override
    public List<Transmission> getAllTransmission() {
        return this.transsmCrud.findByAll();
    }

    @Override
    public Transmission getTransmissionById(int id) {
        return this.transsmCrud.findById(id);
    }

    @Override
    public List<Car> findByAll() {
        return this.carCrud.findByAll();
    }

    @Override
    public Car findById(int id) {
        return this.carCrud.findById(id);
    }

    @Override
    public Car add(Car car) {
        return this.carCrud.save(car);
    }

    @Override
    public void delete(Car car) {
        this.carCrud.delete(car);
    }

    @Override
    public Car update(Car car) {
        return this.carCrud.save(car);
    }


}
