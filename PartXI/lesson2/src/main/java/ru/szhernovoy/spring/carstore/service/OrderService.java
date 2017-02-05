package ru.szhernovoy.spring.carstore.service;

import ru.szhernovoy.spring.carstore.domain.Order;

import java.util.Collection;
import java.util.Map;

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
