package ru.szhernovoy.spring.carstore.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.szhernovoy.spring.carstore.domain.Order;
import ru.szhernovoy.spring.carstore.persistance.OrderCrud;
import ru.szhernovoy.spring.carstore.service.OrderService;

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
        return this.orderCrud.add(order);
    }

    @Override
    public Order update(Order order) {
        return this.orderCrud.update(order);
    }

    @Override
    public boolean delete(Order order) {
        return this.orderCrud.delete(order);
    }

    @Override
    public Order get(int id) {
        return this.orderCrud.getById(id);
    }

    @Override
    public Collection<Order> get() {
        return this.orderCrud.getAll();
    }
}
