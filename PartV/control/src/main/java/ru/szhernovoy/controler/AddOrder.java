package ru.szhernovoy.controler;

import ru.szhernovoy.model.Order;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 27.09.2016.
 */
public class AddOrder implements Action {

    @Override
    public boolean firstRound(Order order, Map<String, Set<Order>> unsort, String nameBookOrder){
        if(!unsort.containsKey(nameBookOrder)){
            Set<Order> setBook = new HashSet<>();
            setBook.add(order);
            unsort.put(nameBookOrder,setBook);
        }
        else{
            Set<Order> setBook = unsort.get(nameBookOrder);
            setBook.add(order);
        }
        return true;
    }
}
