package ru.szhernovoy.service.impl;/**
 * Created by Admin on 05.02.2017.
 */

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.szhernovoy.domain.Order;
import ru.szhernovoy.repositories.OrderCrud;
import ru.szhernovoy.service.OrderService;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

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
    public Order get(int id) {
        return this.orderCrud.findOne(id);
    }

    @Override
    public List<Order> get() {
        return Lists.newArrayList(this.orderCrud.findAll());
    }
}
