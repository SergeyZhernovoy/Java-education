package ru.szhernovoy.store;

import ru.szhernovoy.generic.SimpleArray;

/**
 * Created by Sergey on 08.09.2016.
 */
public class AbstractStore<T> implements Store {

    SimpleArray<T> sa;

    public AbstractStore(int size) {
        this.sa = new SimpleArray<T>(size);
    }

    public AbstractStore(SimpleArray<T> value) {
        this.sa = value;
    }


    public void add(T t) {
        this.sa.add(t);
    }

    public void update(T t,int index) {
        this.sa.update(t, index);
    }

    public void delete(int index) {
        this.sa.delete(index);
    }

    public T get(int index) {
        return this.sa.get(index);
    }



}
