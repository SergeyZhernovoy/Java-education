package ru.szhernovoy.jpa.carstore.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.szhernovoy.jpa.carstore.domain.Car;
import ru.szhernovoy.jpa.carstore.domain.Order;
import ru.szhernovoy.jpa.carstore.persistance.OrderCrud;
import ru.szhernovoy.jpa.carstore.service.OrderService;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    private OrderCrud orderCrud;

    @Autowired
    public OrderServiceImpl(OrderCrud orderCrud) {
        this.orderCrud = orderCrud;
    }

    @Override
    public Order create(Order order) {
        return this.orderCrud.save(order);
    }

    @Override
    public Order update(Order order) {
        return this.orderCrud.save(order);
    }

    @Override
    public void delete(Order order) {
        this.orderCrud.delete(order);
    }

    @Override
    public Order findById(int id) {
        return this.orderCrud.findById(id);
    }

    @Override
    public Order findByCAr(Car car) {
        return this.orderCrud.findByCar(car);
    }

    @Override
    public Collection<Order> findByAll() {
        return this.orderCrud.findByAll();
    }



}
