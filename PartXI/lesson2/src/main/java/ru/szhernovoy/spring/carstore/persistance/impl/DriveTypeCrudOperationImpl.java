package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.DriveType;
import ru.szhernovoy.spring.carstore.persistance.DriveTypeCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriveTypeCrudOperationImpl implements DriveTypeCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriveTypeCrudOperationImpl.class);

    private List<DriveType> list = new ArrayList<>();
    private int id = 0;

    public DriveTypeCrudOperationImpl() {

        DriveType partCar = new DriveType();

        partCar.setName("передний");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new DriveType();
        partCar.setName("задний");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new DriveType();
        partCar.setName("полный");
        partCar.setId(id++);
        list.add(partCar);

    }

    @Override
    public synchronized DriveType add(DriveType driveType) {
        driveType.setId(id++);
        this.list.add(driveType);
        return driveType;
    }

    @Override
    public synchronized boolean delete(DriveType driveType) {
        boolean result = false;
        if(this.list.contains(driveType)){
            this.list.remove(driveType);
            result = true;
        }
        return result;
    }

    @Override
    public synchronized DriveType update(DriveType driveType) {
        if(this.list.contains(driveType)){
            this.list.set(driveType.getId(),driveType);
        }
        return driveType;
    }

    @Override
    public List<DriveType> getAll() {
        return this.list;
    }

    @Override
    public synchronized DriveType getById(int id) {
        DriveType partCar = null;
        for(DriveType driveType : this.getAll()){
            if(driveType.getId() == id){
                partCar = driveType;
                break;
            }
        }
        return partCar;
    }
}
