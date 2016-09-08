package ru.szhernovoy.list;

import java.util.Iterator;

/**
 * Created by admin on 08.09.2016.
 */
public class DynamicArray<E> implements Container<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] obj;
    private int position = 0;

    private DynamicArray(int size){
        this.obj = new Object[size];
    }

    private DynamicArray(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(E e) {
        checkCapacity();
        this.obj[position++] = e;
    }

    private void checkCapacity() {
        grow();
    }

    private void grow() {
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) this.obj[index];
    }

    private void rangeCheck(int index) {
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicIterator<E>();
    }

    private class DynamicIterator<E> implements Iterator<E>{

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws  if the iteration has no more elements
         */
        @Override
        public E next() {
            return null;
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


}