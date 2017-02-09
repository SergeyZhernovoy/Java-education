package ru.szhernovoy.jpa.carstore.service;

import ru.szhernovoy.jpa.carstore.domain.Order;

import java.util.Collection;

/**
 * Created by Admin on 05.02.2017.
 */
public interface OrderService {
    Order create(Order order);
    Order update(Order order);
    boolean delete(Order order);
    Order get(int id);
    Collection<Order> get();
}
