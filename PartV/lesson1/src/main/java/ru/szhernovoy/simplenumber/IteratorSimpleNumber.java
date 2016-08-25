package ru.szhernovoy.simplenumber;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by admin on 25.08.2016.
 */
public class IteratorSimpleNumber implements Iterator {

    private final int[] value;
    private int position = 0;

    public IteratorSimpleNumber(int[] value) {
        this.value = value;
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
        int currentPosition = this.position;
        boolean result = false;
        do {
            int valueArray = this.value[currentPosition++];
            if (checkNumber(valueArray)) {
                result = true;
                break;
            }
        }
        while(currentPosition < this.value.length);

        return result;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws  if the iteration has no more elements
     */
    @Override
    public Object next() {

        int result = Integer.MIN_VALUE;
        do{
            int valueArray = this.value[position++];
            if(valueArray == 1 || checkNumber(valueArray)){
               result = valueArray;
               break;
            }
         }while(this.position < this.value.length);

        if(result == Integer.MIN_VALUE){
            throw new NoSuchElementException();
        }

        return result;

    }

    private boolean checkNumber(int valueArray){
        boolean result = true;
        double sqrt = Math.sqrt(valueArray);
        for(int i=2; i<sqrt; i++)
        {
            if (valueArray%i == 0 ){
                result = false;
                break;
            }
        }
        return result;
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
