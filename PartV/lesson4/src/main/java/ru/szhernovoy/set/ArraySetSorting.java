package ru.szhernovoy.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by admin on 15.09.2016.
 */
public class ArraySetSorting<E> implements Iterator<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] obj;
    private int position = -1;
    private int iterPosition = 0;

    public ArraySetSorting(int size){
        this.obj = new Object[size];
    }

    public ArraySetSorting(){
        this(DEFAULT_CAPACITY);
    }

    public void add(E e) {
        int posArray = binarySearch(e);
        if(posArray != -1) {
            checkCapacity();
            if(this.obj[posArray] != null){
               System.arraycopy(this.obj,posArray,this.obj,posArray+1,this.position-posArray+1);
            }
            this.obj[posArray] = e;
            this.position++;
        }
    }

    private int  binarySearch(E e){

        int lowerBound = 0;
        int upperBound = this.position ;
        int curIn;
        int result = 0;

        if(this.position != -1) {

        while(true){
            curIn = (lowerBound + upperBound ) / 2;
            if(this.obj[curIn].hashCode()== e.hashCode()) {
                result = -1;
                break;
            }
            else if(lowerBound > upperBound){
                result = lowerBound;
                break;}
            else{
                if(this.obj[curIn].hashCode() < e.hashCode()) {
                    lowerBound = curIn + 1; // В верхней половине
                }
                else {
                    upperBound = curIn - 1; // В нижней половине
                }
            }
          }

        }
        return  result;
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
        boolean result = this.iterPosition != (position+1);
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