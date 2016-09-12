package ru.szhernovoy.linkedlist;

/**
 * Created by admin on 12.09.2016.
 */
public class QueueLinkedList<T> extends DynamicLinkedList<T> implements IQueue<T>{

    @Override
    public void push(T t){
        super.add(t);
    }

    @Override
    public T pop() {
        return super.remove(getCapacility()-1);
    }

}
