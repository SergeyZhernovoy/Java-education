package ru.szhernovoy.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by szhernovoy on 22.09.2016.
 */
public class SimpleTreeWithSearch<E> {

    private Leaf<E> root;
    private boolean balance = true;

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
    public List<Leaf<E>> getChildren(){
        List<Leaf<E>> resultArray = new ArrayList<>();
        Iterator<Leaf<E>> iter = new IteratorSimpleTree();
        while(iter.hasNext()){
            resultArray.add(iter.next());
        }
        return resultArray;
    }


    public Leaf<E> searchByValue(E e ){

        Iterator<Leaf<E>> iter = new IteratorSimpleTree();
        Leaf<E> findLeaf = null;
        while(iter.hasNext()){
            findLeaf = iter.next();
            if(e.equals(findLeaf.getValue())){
                break;
            }
        }
        return findLeaf;
    }

    public boolean isBalance(){
        this.treeIsBalance(this.root);
        return this.balance;
    }


    private void treeIsBalance(Leaf<E> branch){
            if(this.balance){
                List<Leaf<E>> child = branch.getChildrenLeaf();
                int count = 0;
                for(Leaf<E> one : child){
                    if(!this.balance){
                        break;
                    }
                    if(count >= 2 ){
                        this.balance = false;
                        break;
                    }
                    count++;
                    this.treeIsBalance(one);
                  }
            }
    }


    /**
     * class Iterator
     */
    private class IteratorSimpleTree implements Iterator<Leaf<E>>{

        private Leaf<E> currentLeaf;
        private List<Leaf<E>> listLeaf = new ArrayList<>();
        private Iterator<Leaf<E>> inner;


        public IteratorSimpleTree(){
            this.currentLeaf = root;
            if(root != null){
                this.listLeaf.add(root);
                arrayFilling(root);
                this.inner = this.listLeaf.iterator();
            }
        }

        private void arrayFilling(Leaf<E> leaf){

            List<Leaf<E>> current = leaf.getChildrenLeaf();
            this.listLeaf.addAll(current);
            for(int index = 0; index < leaf.getCountLeaf();index++){
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
        public Leaf<E> next() {

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
