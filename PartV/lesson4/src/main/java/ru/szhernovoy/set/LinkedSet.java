package ru.szhernovoy.set;

import ru.szhernovoy.linkedlist.DynamicLinkedList;

import java.util.Iterator;

/**
 * Created by admin on 14.09.2016.
 */
public class LinkedSet<E> implements Iterator<E>{

    private DynamicLinkedList<E> dlink;
    private Iterator<E> iter;

    public LinkedSet(){
        this.dlink = new DynamicLinkedList<>();
        this.iter = this.dlink.iterator();
    }

    public boolean add(E e){
        boolean result = false;
        if(!this.dlink.checkDuplicate(e)){
           this.dlink.add(e);
            result = true;
        }
        return result;
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
         return this.iter.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws  if the iteration has no more elements
     */
    @Override
    public E next() {
        E value = null;
        if(this.iter.hasNext()){
            value = this.iter.next();
        }
        return (E) value;
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.  The behavior of an iterator
     * is unspecified if the underlying collection is modified while the
     * iteration is in progress in any way other than by calling this
     * method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     * @implSpec The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     */
    @Override
    public void remove() {

    }
}
