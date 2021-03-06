package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.Body;
import ru.szhernovoy.spring.carstore.persistance.BodyCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BodyCrudOperationImpl implements BodyCrud {

    private List<Body> list = new ArrayList<>();
    private int id = 0;

    public BodyCrudOperationImpl() {

        Body partCar = new Body();

        partCar.setName("хэтчбек");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Body();
        partCar.setName("седан");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Body();
        partCar.setName("внедорожник");
        partCar.setId(id++);
        list.add(partCar);

        partCar = new Body();
        partCar.setName("кабриолет");
        partCar.setId(id++);
        list.add(partCar);

    }

    @Override
    public synchronized Body add(Body body) {
        body.setId(id++);
        this.list.add(body);
        return body;
    }

    @Override
    public synchronized boolean delete(Body body) {
        boolean result = false;
        if(this.list.contains(body)){
            this.list.remove(body);
            result = true;
        }
        return result;
    }

    @Override
    public synchronized Body update(Body body) {

        if(this.list.contains(body)){
            this.list.set(body.getId(),body);
        }
        return body;
    }

    @Override
    public List<Body> getAll() {
        return this.list;
    }

    @Override
    public Body getById(int id) {

        Body newBody = null;
        for(Body body : this.getAll()){
            if(body.getId() == id){
                newBody = body;
                break;
            }
        }
        return newBody;
    }
}
