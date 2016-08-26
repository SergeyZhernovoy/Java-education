package ru.szhernovoy.convert;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by szhernovoy on 26.08.2016.
 */
public class IteratorSimple implements IteratorConvert {

    private final int[] value;
    private int position = 0;

    public IteratorSimple(int[] value) {
        this.value = value;
    }


    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return null;
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
         return this.position < this.value.length;
     }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws  if the iteration has no more elements
     */
    @Override
    public Integer next() {

        if(this.position < this.value.length){
             return this.value[position++];
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
