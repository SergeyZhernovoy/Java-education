package ru.szhernovoy.jpa.carstore.service;

import ru.szhernovoy.jpa.carstore.domain.Car;
import ru.szhernovoy.jpa.carstore.domain.Order;

import java.util.Collection;

/**
 * Created by Admin on 05.02.2017.
 */
public interface OrderService {
    Order create(Order order);
    Order update(Order order);
    void delete(Order order);
    Order findById(int id);
    Order findByCAr(Car car);
    Collection<Order> findByAll();
}
