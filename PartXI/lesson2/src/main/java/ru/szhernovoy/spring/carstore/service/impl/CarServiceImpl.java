package ru.szhernovoy.spring.carstore.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.szhernovoy.spring.carstore.domain.*;
import ru.szhernovoy.spring.carstore.persistance.*;
import ru.szhernovoy.spring.carstore.service.CarService;

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
        return this.bodyCrud.getAll();
    }

    @Override
    public Body getBodyById(int id) {
        return this.bodyCrud.getById(id);
    }

    @Override
    public List<Engine> getAllEngine() {
        return this.engineCrud.getAll();
    }

    @Override
    public Engine getEngineById(int id) {
        return this.engineCrud.getById(id);
    }

    @Override
    public List<DriveType> getAllDriveType() {
        return this.driveTypeCrud.getAll();
    }

    @Override
    public DriveType getDriveTypeById(int id) {
        return this.driveTypeCrud.getById(id);
    }

    @Override
    public List<Model> getAllModel() {
        return this.modelCrud.getAll();
    }

    @Override
    public Model getModelById(int id) {
        return this.modelCrud.getById(id);
    }

    @Override
    public List<Transmission> getAllTransmission() {
        return this.transsmCrud.getAll();
    }

    @Override
    public Transmission getTransmissionById(int id) {
        return this.transsmCrud.getById(id);
    }

    @Override
    public List<Car> getAllCar() {
        return this.carCrud.getAll();
    }

    @Override
    public Car getCarById(int id) {
        return this.carCrud.getById(id);
    }

    @Override
    public Car add(Car car) {
        return this.carCrud.add(car);
    }

    @Override
    public boolean delete(Car car) {
        return this.carCrud.delete(car);
    }

    @Override
    public Car update(Car car) {
        return this.carCrud.update(car);
    }


}
