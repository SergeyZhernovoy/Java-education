package ru.szhernovoy.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by admin on 13.09.2016.
 */
public class SimpleSet<E> {

    private static final Object PRESENT = new Object();
    private Map<E,Object> map = new HashMap<>();

    public boolean add(E e) {
       return this.map.put(e,PRESENT) == null;
    }

    public Iterator<E> iterator() {
        return new IteratorSet<E>();
    }

    private class IteratorSet<E> implements Iterator<E>{

        private Iterator<E> iter;

        public IteratorSet(){
            this.iter = (Iterator<E>) map.keySet().iterator();
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
            if(this.iter.hasNext()){
                return (E)this.iter.next();
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
}
