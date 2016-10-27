package ru.szhernovoy.nonblock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by szhernovoy on 27.10.2016.
 */
public class Cash<E> {

    private Map<E,Object> cash = new ConcurrentHashMap<>();

    public void add(E e){
        this.cash.put(e,new Object());

    }

    public void delete(E e){
        this.cash.remove(e);

    }

    public void update(E e){
        this.cash.put(e,new Object());
    }


}
