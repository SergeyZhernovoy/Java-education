package ru.szhernovoy.carstore.dao;

import java.util.Collection;

/**
 * Created by admin on 10.01.2017.
 */
public interface DAOInterface<T> {
    T create(T t);
    T  update(T t);
    boolean delete(T t);
    Collection<T> get(int id);
    Collection<T> get();
}
