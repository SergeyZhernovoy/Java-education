package ru.szhernovoy.carstore.dao;

import com.google.gson.JsonArray;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.model.Car;

import java.util.Collection;

/**
 * Created by admin on 14.01.2017.
 */
public class CarDBManager implements DAOInterface<Car>, JsonConvert<Car> {
    private final static Logger log = LoggerFactory.getLogger(CarDBManager.class);

    @Override
    public JsonArray convert(Collection<Car> collection) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param car .
     * @return T
     */
    @Override
    public Car create(Car car) {



        return car;


    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param car .
     * @return T
     */
    @Override
    public Car update(Car car) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param car .
     * @return boolean
     */
    @Override
    public boolean delete(Car car) {
        return false;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @param id .
     * @return Collection<T>
     */
    @Override
    public Collection<Car> get(int id) {
        return null;
    }

    /**
     * Created by admin on 10.01.2017.
     *
     * @return Collection<T>
     */
    @Override
    public Collection<Car> get() {
        return null;
    }
}
