package ru.szhernovoy.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.szhernovoy.repositories.*;
import ru.szhernovoy.service.CarService;
import ru.szhernovoy.domain.*;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private CarCrud carCrud;
    private BodyCrud bodyCrud;
    private DriveTypeCrud driveTypeCrud;
    private ModelCrud modelCrud;
    private TranssmCrud transsmCrud;
    private EngineCrud engineCrud;

    @Autowired
    public CarServiceImpl(BodyCrud bodyCrud, DriveTypeCrud driveTypeCrud, ModelCrud modelCrud, TranssmCrud transsmCrud, EngineCrud engineCrud,CarCrud carCrud) {
        this.bodyCrud = bodyCrud;
        this.driveTypeCrud = driveTypeCrud;
        this.modelCrud = modelCrud;
        this.transsmCrud = transsmCrud;
        this.engineCrud = engineCrud;
        this.carCrud = carCrud;
    }

    @Override
    public List<Body> getAllBody() {
        return Lists.newArrayList(this.bodyCrud.findAll());
    }

    @Override
    public Body getBodyById(int id) {
        return this.bodyCrud.findOne(id);
    }

    @Override
    public List<Engine> getAllEngine() {
        return Lists.newArrayList(this.engineCrud.findAll());
    }

    @Override
    public Engine getEngineById(int id) {
        return this.engineCrud.findOne(id);
    }

    @Override
    public List<DriveType> getAllDriveType() {
        return Lists.newArrayList(this.driveTypeCrud.findAll());
    }

    @Override
    public DriveType getDriveTypeById(int id) {
        return this.driveTypeCrud.findOne(id);
    }

    @Override
    public List<Model> getAllModel() {
        return Lists.newArrayList(this.modelCrud.findAll());
    }

    @Override
    public Model getModelById(int id) {
        return this.modelCrud.findOne(id);
    }

    @Override
    public List<Transmission> getAllTransmission() {
        return Lists.newArrayList(this.transsmCrud.findAll());
    }

    @Override
    public Transmission getTransmissionById(int id) {
        return this.transsmCrud.findOne(id);
    }

    @Override
    public List<Car> getAllCar() {
        return Lists.newArrayList(this.carCrud.findAll());
    }

    @Override
    public Car getCarById(int id) {
        return this.carCrud.findOne(id);
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
