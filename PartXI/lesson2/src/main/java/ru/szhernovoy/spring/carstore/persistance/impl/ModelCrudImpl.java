package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.Model;
import ru.szhernovoy.spring.carstore.persistance.ModelCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ModelCrudImpl implements ModelCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelCrudImpl.class);
    private List<Model> list = new ArrayList<>();

    private int id = 0;

    public ModelCrudImpl() {
        Model partCar = new Model();

        partCar.setName("audi");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Model();
        partCar.setName("bmw");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Model();
        partCar.setName("газ");
        partCar.setId(id++);
        list.add(partCar);
    }

    @Override
    public synchronized Model add(Model model) {
        return null;
    }

    @Override
    public synchronized boolean delete(Model model) {
        return false;
    }

    @Override
    public synchronized Model update(Model model) {
        return null;
    }

    @Override
    public List<Model> getAll() {
        return this.list;
    }

    @Override
    public Model getById(int id) {
        Model partCar = null;
        for(Model driveType : this.getAll()){
            if(driveType.getId() == id){
                partCar = driveType;
                break;
            }
        }
        return partCar;
    }
}
