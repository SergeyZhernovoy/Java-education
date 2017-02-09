package ru.szhernovoy.jpa.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.jpa.carstore.domain.Car;
import ru.szhernovoy.jpa.carstore.persistance.CarCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarCrudOperationImpl implements CarCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarCrudOperationImpl.class);

    private List<Car> list = new ArrayList<>();
    private int id = 0;

    @Override
    public Car add(Car car) {
        car.setId(id++);
        this.list.add(car);
        return car;
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public Car update(Car car) {
        if(this.list.contains(car)){
            this.list.set(car.getId(),car);
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        return this.list;
    }

    @Override
    public Car getById(int id) {
        Car partCar = null;
        for(Car driveType : this.getAll()){
            if(driveType.getId() == id){
                partCar = driveType;
                break;
            }
        }
        return partCar;
    }
}
