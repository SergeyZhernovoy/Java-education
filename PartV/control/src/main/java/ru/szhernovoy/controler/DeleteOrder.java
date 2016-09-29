package ru.szhernovoy.controler;

import ru.szhernovoy.model.Order;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by admin on 27.09.2016.
 */
public class DeleteOrder implements Action {

    @Override
    public boolean firstRound(Order order, Map<String, Set<Order>> unsort,String nameBook) {
        if(unsort.containsKey(nameBook)){
            Set<Order> setBook = unsort.get(nameBook);
            setBook.remove(order);
        }
        else{
            throw new NoSuchElementException("This BookOrder is not");
        }
        return true;
    }
}
