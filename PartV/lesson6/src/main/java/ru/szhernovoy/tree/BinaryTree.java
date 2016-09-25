package ru.szhernovoy.tree;

import java.util.Map;

/**
 * Created by Sergey on 25.09.2016.
 */
public class BinaryTree<T extends Comparable<T>, V> {

    private Node<T,V> root = null;


    public void put(T key, V value){

        Node<T,V> x = root, y = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.value = value;
                break;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.rigth;
                }
            }
        }
        Node<T,V> newNode = new Node<>(null,null,null,key,value);
        if (y == null) {
            root = newNode;
        } else {
            if (key.compareTo(y.key) < 0) {
                y.left = newNode;

            } else {
                y.rigth = newNode;
            }
            newNode.parent = y;
        }

    }

    public V get(T key){

        Node<T,V> x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.value;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.rigth;
            }
        }
        return null;
    }


    private class Node<T,V> implements Map.Entry<T,V>{

        Node<T,V> left;
        Node<T,V> rigth;
        Node<T,V> parent;

        T key;
        V value;

        public Node(Node<T, V> left, Node<T, V> rigth, Node<T, V> parent, T key, V value) {
            this.left = left;
            this.rigth = rigth;
            this.parent = parent;
            this.key = key;
            this.value = value;
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
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

}
