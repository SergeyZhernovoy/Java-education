package ru.szhernovoy.spring.carstore.service;

import ru.szhernovoy.spring.carstore.domain.*;


import java.util.List;

/**
 * Created by Admin on 05.02.2017.
 */
public interface CarService  {

    List<Body> getAllBody();
    Body getBodyById(int id);

    List<Engine> getAllEngine();
    Engine getEngineById(int id);

    List<DriveType> getAllDriveType();
    DriveType getDriveTypeById(int id);

    List<Model> getAllModel();
    Model getModelById(int id);

    List<Transmission> getAllTransmission();
    Transmission getTransmissionById(int id);

    List<Car> getAllCar();
    Car getCarById(int id);

    Car add(Car car);
    boolean delete(Car cart);
    Car update(Car car);

}
