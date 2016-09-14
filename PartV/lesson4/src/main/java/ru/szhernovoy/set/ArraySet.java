package ru.szhernovoy.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by admin on 14.09.2016.
 */
public class ArraySet<E> implements Iterator<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] obj;
    private int position = 0;
    private int iterPosition = 0;

    public ArraySet(int size){
        this.obj = new Object[size];
    }

    public ArraySet(){
        this(DEFAULT_CAPACITY);
    }

    public void add(E e) {
        if(checkValue(e)) {
            checkCapacity();
            this.obj[position++] = e;
        }
    }

    public boolean checkValue(E e){
        boolean result = true;

        for(int index = 0 ; index < this.obj.length; index++){
            if(this.obj[index]!= null && this.obj[index].equals(e)){
                result = false;
                break;
            }
        }

        return result;
    }

    private void checkCapacity() {
        if(this.obj.length == (position+1)){
            grow();
        }

    }

    public int getSize(){
        return this.obj.length;
    }


    private void grow() {
        int newCapacity = this.obj.length + (this.obj.length >> 3);
        this.obj = Arrays.copyOf(this.obj,newCapacity);
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
        boolean result = this.iterPosition != position;
        if(!result){
            this.iterPosition = 0;
        }
        return result;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws  if the iteration has no more elements
     */
    @Override
    public E next() {
        if(this.hasNext()){
            return (E) this.obj[iterPosition++];
        }
        else{
            throw new NoSuchElementException();
        }
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