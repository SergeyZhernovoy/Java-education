package ru.szhernovoy.map;


import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by admin on 20.09.2016.
 */
public class PhoneBook<T,V>  {

    private Node<T,V>[] table;
    private int capacity = 16;
    private int size = 0;

    public PhoneBook(){
        this.table = new Node[this.capacity];

    }

    public boolean insert(T key, V value){

        if(this.table.length == 0 || this.table == null || size > (this.table.length -1)){
            this.table = this.resize();
        }

        return addValue(hash(key),key,value) == null;
    }

    final V addValue(int hash, T key, V value) {

        Node<T, V> current;
        int index = this.indexOfTable(hash,this.table.length);
        if ((current = this.table[index]) == null) {
            this.table[index] = newNode(hash, key, value, null);
        } else {
            Node<T, V> e;
            if (current.hash == hash && (current.key == key || key.equals(current.key))) {
                e = current;
            } else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = current.next) == null) {
                        current.next = newNode(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash && (e.key == key || key.equals(e.key))) {
                        break;
                    }
                }
            }
        }
        size++;

        return null;
    }

    private int indexOfTable(int hash, int length){
        return  (length - 1)& hash;
    }

    // Create a regular (non-tree) node
    Node<T,V> newNode(int hash, T key, V value, Node<T,V> next) {
        return new Node<>(hash, key, value, next);
    }

    final Node<T,V>[] resize() {

        int newCapacity = this.table.length*2;
        Node<T,V>[] newTab = (Node<T,V>[])new Node[newCapacity];
        for (int j = 0; j < this.table.length; ++j) {
            Node<T, V> e;
            if ((e = this.table[j]) != null) {
                newTab[indexOfTable(e.hash,newCapacity)] = e;
            }
        }

        return newTab;
    }

    public V get(T key){
        Node<T,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<T,V> getNode(int hash, T key) {

        Node<T,V> first, e;
        int n; T k;
        if (this.table != null && this.table.length > 0 && (first = this.table[indexOfTable(hash,this.table.length)]) != null) {
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&  ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    public boolean delete(T key){
        return removeNode(hash(key), key) != null;

    }

    final Node<T,V> removeNode(int hash, T key) {

        Node<T,V> p = null,e;
        Node<T,V> node = null;

        if (this.table != null && this.table.length > 0 && (p = this.table[indexOfTable(hash,this.table.length)]) != null) {

            if (p.hash == hash &&  (p.key == key || (key != null && key.equals(p.key)))) {
                node = p;
            }

            else {
                while ((e = p.next) != null){
                    if (e.hash == hash && e.key == key ||  (key != null && key.equals(e.key))) {
                        node = e;
                        break;
                    }
                    p = e;
                }
            }
        }
        if (node != null ) {
            if (node == p) {
                this.table[indexOfTable(hash, this.table.length)] = node.next;
            }
            else{
                p.next = node.next;
            }
            --size;
            return node;
        }

        return null;
    }

    public IterPhoneBook<T, V> iterator(){
        return new IterPhoneBook<T,V>();
    }

    private final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private class Node<T,V> implements Map.Entry<T,V> {
        Node<T,V> next;
        T key;
        V value;
        final int hash;

        public Node(final int hash,T key, V value, Node<T,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *                               required to, throw this exception if the entry has been
         *                               removed from the backing map.
         */
        @Override
        public T getKey() {
            return this.key;
        }

        /**
         * Returns the value corresponding to this entry.  If the mapping
         * has been removed from the backing map (by the iterator's
         * <tt>remove</tt> operation), the results of this call are undefined.
         *
         * @return the value corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *                               required to, throw this exception if the entry has been
         *                               removed from the backing map.
         */
        @Override
        public V getValue() {
            return this.value;
        }

        /**
         * Replaces the value corresponding to this entry with the specified
         * value (optional operation).  (Writes through to the map.)  The
         * behavior of this call is undefined if the mapping has already been
         * removed from the map (by the iterator's <tt>remove</tt> operation).
         *
         * @param value new value to be stored in this entry
         * @return old value corresponding to the entry
         * @throws UnsupportedOperationException if the <tt>put</tt> operation
         *                                       is not supported by the backing map
         * @throws ClassCastException            if the class of the specified value
         *                                       prevents it from being stored in the backing map
         * @throws NullPointerException          if the backing map does not permit
         *                                       null values, and the specified value is null
         * @throws IllegalArgumentException      if some property of this value
         *                                       prevents it from being stored in the backing map
         * @throws IllegalStateException         implementations may, but are not
         *                                       required to, throw this exception if the entry has been
         *                                       removed from the backing map.
         */
        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    private class IterPhoneBook<T,V> implements Iterator <V>{

        int position = 0;
        boolean innerLoop = false;
        Node<T,V> e;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            initNode();
            if(e!=null && e.next !=null || position != table.length) {
               result = true;
            }
            return  result;
        }

        private void initNode(){

            while(position < table.length && !innerLoop ){
                if(table[position] != null){
                    e = (Node<T, V>) table[position];
                    break;
                }
                position++;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws  if the iteration has no more elements
         */
        @Override
        public V next() {
            Node<T,V> node;

            if(hasNext()){
                if(e.next != null) {
                    innerLoop = true;
                    node = e;
                    e = e.next;
                }
                else {
                    node = e;
                    position++;
                    innerLoop = false;
                }
            }
            else{
                throw new NoSuchElementException();
            }
            return node.value;
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
