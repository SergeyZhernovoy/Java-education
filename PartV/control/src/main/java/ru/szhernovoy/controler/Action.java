package ru.szhernovoy.controler;


import ru.szhernovoy.model.Order;

import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 27.09.2016.
 */
public interface Action {
    boolean firstRound(Order order, Map<String,Set<Order>> unsort,String nameBookOrder);
}
