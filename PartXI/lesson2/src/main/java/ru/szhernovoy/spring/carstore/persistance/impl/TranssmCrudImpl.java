package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.Transmission;
import ru.szhernovoy.spring.carstore.persistance.TranssmCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TranssmCrudImpl implements TranssmCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranssmCrudImpl.class);

    private List<Transmission> list = new ArrayList<>();

    private int id = 0;

    public TranssmCrudImpl() {
        Transmission partCar = new Transmission();

        partCar.setName("механика");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Transmission();
        partCar.setName("автомат");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Transmission();
        partCar.setName("робот");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Transmission();
        partCar.setName("вариатор");
        partCar.setId(id++);
        list.add(partCar);
    }

    @Override
    public Transmission add(Transmission transmission) {
        return null;
    }

    @Override
    public boolean delete(Transmission transmission) {
        return false;
    }

    @Override
    public Transmission update(Transmission transmission) {
        return null;
    }

    @Override
    public List<Transmission> getAll() {
        return this.list;
    }

    @Override
    public Transmission getById(int id) {
            Transmission partCar = null;
            for(Transmission driveType : this.getAll()){
                if(driveType.getId() == id){
                    partCar = driveType;
                    break;
                }
            }
            return partCar;

    }
}
