package ru.szhernovoy.list;

/**
 * Created by Sergey on 08.09.2016.
 */
public interface Container<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}
