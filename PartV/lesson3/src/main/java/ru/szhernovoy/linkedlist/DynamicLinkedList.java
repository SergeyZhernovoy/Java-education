package ru.szhernovoy.linkedlist;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Sergey on 09.09.2016.
 */
public class DynamicLinkedList<T> implements ContainerLinked<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;


    @Override
    public boolean add(T t) {
        Node<T> next = this.last;
        Node<T> newNode = new Node<>(t,next,null);
        this.last = newNode;
        if(next == null){
          first = newNode;
        }
        else{
          next.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public T get(int index) {
          return (T) node(index).item;
    }

    public Node<T> node(int index){

        Node<T> node = first;
        if(this.size != 0 && index < this.size){
            for(int i = 0; i < index; i++){
                node = node.next;
            }
        }
        else{
            throw new NoSuchElementException("No elements in linked list");
        }
        return node;

    }

    public int getCapacility(){
        return this.size;
    }

    @Override
    public T remove(int index) {
        Node<T> node = node(index);
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if(prev != null){
           prev.next = next;
        }

        if(next != null){
           next.prev = prev;
        }
        this.size--;
        return (T) node.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<T>();
    }


    private class Node<T>{
        T item;
        Node<T> next;
        Node<T> prev;
        public Node(T item, Node<T> prev, Node<T> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator<T> implements Iterator<T>{

        private int position = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return this.position < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if(hasNext()){
               return (T) get(position++);
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

    public boolean checkDuplicate(T t){
        boolean result = false;
        Node<T> node = first;
        if(this.size != 0){
            for(int i = 0; i < this.size; i++){
                T value = (T) node.item;
                if(value.equals(t)){
                   result = true;
                   break;
                }
                node = node.next;
            }
        }


        return result;
    }

}
