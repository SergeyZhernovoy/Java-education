package ru.szhernovoy.array;

import ru.szhernovoy.list.DynamicArray;

/**
 * Created by Sergey on 15.10.2016.
 */
public class SynchronizedDynamicArray<E> {

    private DynamicArray<E> array;

    public SynchronizedDynamicArray(final DynamicArray<E> array){
        this.array = array;
    }

    public  SynchronizedDynamicArray(int capacity){
        this.array = new DynamicArray<>(capacity);
    }


    public synchronized void add(E e ){
        this.array.add(e);
    }

    public synchronized E get(int index){
        return (E) this.array.get(index);
    }

}
