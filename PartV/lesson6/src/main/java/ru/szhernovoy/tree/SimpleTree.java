package ru.szhernovoy.tree;

/**
 * Created by szhernovoy on 22.09.2016.
 */
public class SimpleTree<T extends Comparable<T>,V> {
    private Node<T,V> root;

    /**
     * Created by admin on 22.09.2016.
     */
    private class Node<T,V> {

         private T key;
         private V value;

         private Node<T,V> lefr;
         private Node<T,V> rigth;
         private Node<T,V> parent;


        public Node(T key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<T, V> getLefr() {
            return lefr;
        }

        public void setLefr(Node<T, V> lefr) {
            this.lefr = lefr;
        }

        public Node<T, V> getRigth() {
            return rigth;
        }

        public void setRigth(Node<T, V> rigth) {
            this.rigth = rigth;
        }

        public Node<T, V> getParent() {
            return parent;
        }

        public void setParent(Node<T, V> parent) {
            this.parent = parent;
        }
    }
}
