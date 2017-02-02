package ru.szhernovoy.spring.carstore.persistence;

/**
 * Created by Admin on 01.02.2017.
 */
public interface Crud<T> {
    T add(T t);
    T get(int id);
}
