package ru.szhernovoy.spring.carstore.persistance.impl;/**
 * Created by Admin on 05.02.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.szhernovoy.spring.carstore.domain.Order;
import ru.szhernovoy.spring.carstore.persistance.OrderCrud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderCrudImpl implements OrderCrud {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCrudImpl.class);

    private List<Order> list = new ArrayList<>();
    private int id = 0;


    @Override
    public Order add(Order order) {
        order.setId(id++);
        this.list.add(order);
        return order;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }

    @Override
    public Order update(Order order) {
        if(this.list.contains(order)){
            this.list.set(order.getId(),order);
        }
        return order;
    }

    @Override
    public List<Order> getAll() {
        return this.list;
    }

    @Override
    public Order getById(int id) {
        Order order = null;
        for(Order next : this.getAll()){
            if(next.getId() == id){
                order = next;
                break;
            }
        }
        return order;
    }
}
