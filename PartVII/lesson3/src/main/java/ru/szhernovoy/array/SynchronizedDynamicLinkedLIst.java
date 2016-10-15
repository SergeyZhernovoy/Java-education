package ru.szhernovoy.array;

import ru.szhernovoy.linkedlist.DynamicLinkedList;

/**
 * Created by Sergey on 15.10.2016.
 */
public class SynchronizedDynamicLinkedLIst<E> {

    private DynamicLinkedList<E> array;

    public SynchronizedDynamicLinkedLIst(DynamicLinkedList<E> array) {
        this.array = array;
    }

    public SynchronizedDynamicLinkedLIst() {
        this.array = new DynamicLinkedList<>();
    }

    public synchronized boolean add(E e){
        return this.array.add(e);
    }

    public synchronized E get(int index){
        return (E) this.array.get(index);
    }

    public  synchronized  E remove(int index){
        return (E) this.array.remove(index);
    }


}
