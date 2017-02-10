package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.Engine;
import ru.szhernovoy.spring.carstore.persistance.EngineCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EngineCrudImpl implements EngineCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(EngineCrudImpl.class);

    private List<Engine> list = new ArrayList<>();
    private int id = 0;

    public EngineCrudImpl() {
        Engine partCar = new Engine();

        partCar.setName("бензин");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Engine();
        partCar.setName("дизель");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Engine();
        partCar.setName("газ");
        partCar.setId(id++);
        list.add(partCar);
    }

    @Override
    public synchronized Engine add(Engine engine) {
        engine.setId(id++);
        this.list.add(engine);
        return engine;
    }

    @Override
    public synchronized boolean delete(Engine engine) {
        boolean result = false;
        if(this.list.contains(engine)){
            this.list.remove(engine);
            result = true;
        }
        return result;
    }

    @Override
    public synchronized Engine update(Engine engine) {
        if(this.list.contains(engine)){
            this.list.set(engine.getId(),engine);
        }
        return engine;
    }

    @Override
    public List<Engine> getAll() {
        return this.list;
    }

    @Override
    public Engine getById(int id) {
        Engine partCar = null;
        for(Engine driveType : this.getAll()){
            if(driveType.getId() == id){
                partCar = driveType;
                break;
            }
        }
        return partCar;
    }
}
