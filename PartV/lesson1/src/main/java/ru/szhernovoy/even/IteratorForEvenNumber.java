package ru.szhernovoy.even;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by admin on 25.08.2016.
 */
public class IteratorForEvenNumber implements Iterator {

    private final int[] value;
    private int position = 0;

    public IteratorForEvenNumber(int[] value) {
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
            if (this.value[currentPosition++] % 2 == 0) {
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

        do {
            result = this.value[position++];
            if (result % 2 == 0) {
                break;
            }
        }
        while(this.position < this.value.length);

        if(result == Integer.MIN_VALUE){
           throw new NoSuchElementException();
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
