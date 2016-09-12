package ru.szhernovoy.linkedlist;

/**
 * Created by Sergey on 08.09.2016.
 */
public interface ContainerLinked<E> extends Iterable<E> {
    boolean add(E e);
    E get(int index);
    E remove(int index);
}
