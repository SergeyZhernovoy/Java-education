package ru.szhernovoy.jpa.carstore.service;


import ru.szhernovoy.jpa.carstore.domain.Order;

import java.util.List;

/**
 * Created by Admin on 05.02.2017.
 */
public interface OrderService {
    Order create(Order order);
    Order update(Order order);
    void delete(Order order);
    Order get(int id);
    List<Order> get();
}
