package ru.szhernovoy.tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by szhernovoy on 22.09.2016.
 */
public class SimpleTree<E> {

    private Leaf<E> root;

    /**
     * Method auto add leafs in tree.
     * @param simpleLeaF
     * @param value
     * @return
     */
    public boolean addChild(Leaf<E> simpleLeaF, E value){
        boolean result = false;
        simpleLeaF.setValue(value);
        if(this.root == null){
            this.root = simpleLeaF;
            result = true;
        }
        else{
            this.root.addNext(simpleLeaF);
            result = true;
        }
        return result;
    }

    /**
     * Get list all children
     * @return
     */
    public List<E> getChildren(){
        List<E> resultArray = new ArrayList<>();
        Iterator<E> iter = new IteratorSimpleTree();
        while(iter.hasNext()){
            resultArray.add(iter.next());
        }
        return resultArray;
    }

    /**
     * class Iterator
     */
    private class IteratorSimpleTree implements Iterator<E>{


        private int position = 0;
        private Leaf<E> currentLeaf;
        private List<E> listLeaf = new ArrayList<>();
        private Iterator<E> inner;


        public IteratorSimpleTree(){
            this.currentLeaf = root;
            if(root != null){
                this.listLeaf.add((E) root);
                arrayFilling(root);
                this.inner = this.listLeaf.iterator();
            }
        }

        private void arrayFilling(Leaf<E> leaf){

            List<Leaf<E>> current = leaf.getChildrenLeaf();
            for(int index = 0; index < leaf.getCountLeaf();index++){
                this.listLeaf.add(current.get(index).getValue());
                arrayFilling(current.get(index));
            }

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

            return this.listLeaf.isEmpty()? false: this.inner.hasNext();

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
                return this.inner.next();

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
