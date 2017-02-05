package ru.szhernovoy.spring.carstore.persistance;

import java.util.List;

/**
 * Created by Admin on 05.02.2017.
 */
public interface CrudOperation<T> {
    T add(T t);
    boolean delete(T t);
    T update(T t);
    List<T> getAll();
    T getById(int id);
}
